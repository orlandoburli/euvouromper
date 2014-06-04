package br.com.orlandoburli.euvouromper.web.servlets.utils.indexer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import br.com.orlandoburli.euvouromper.model.be.admin.ParametroBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.web.filters.InjectionFilter;

public final class LuceneSearcher {

	public List<BaseVo> buscar(String keyword, DAOManager manager) throws ListException {
		IndexReader r = null;
		IndexSearcher s = null;

		try {
			String diretorio = new ParametroBe(manager).get(Constants.Parameters.PATH_LUCENE).getValor();

			StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_48);

			r = DirectoryReader.open(FSDirectory.open(new File(diretorio)));
			s = new IndexSearcher(r);

			Query query = new QueryParser(Version.LUCENE_48, "ConteudoFull", analyzer).parse(keyword);

			TopScoreDocCollector collector = TopScoreDocCollector.create(1000, true);
			s.search(query, collector);

			ScoreDoc[] hits = collector.topDocs().scoreDocs;

			List<BaseVo> list = new ArrayList<BaseVo>();

			for (int i = 0; i < collector.getTotalHits(); i++) {

				Document document = s.doc(hits[i].doc);

				BaseVo vo = DocumentToVo(document);

				if (vo != null) {
					list.add(vo);
				}
			}

			return list;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	private BaseVo DocumentToVo(Document doc) {
		String className = doc.get("className");

		try {

			BaseVo vo = (BaseVo) Class.forName(className).newInstance();

			for (IndexableField f : doc.getFields()) {
				InjectionFilter.setproperty(vo, f.name(), doc.get(f.name()));
			}

			return vo;

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
}