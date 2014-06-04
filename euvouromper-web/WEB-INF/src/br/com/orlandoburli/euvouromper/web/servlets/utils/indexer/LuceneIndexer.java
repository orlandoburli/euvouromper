package br.com.orlandoburli.euvouromper.web.servlets.utils.indexer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

import br.com.orlandoburli.euvouromper.model.be.admin.ParametroBe;
import br.com.orlandoburli.euvouromper.model.be.cadastros.ProfessorBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.be.site.ArtigoBe;
import br.com.orlandoburli.euvouromper.model.be.site.InstitucionalBe;
import br.com.orlandoburli.euvouromper.model.be.site.NoticiaBe;
import br.com.orlandoburli.euvouromper.model.vo.cadastros.ProfessorVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.site.ArtigoVo;
import br.com.orlandoburli.euvouromper.model.vo.site.InstitucionalVo;
import br.com.orlandoburli.euvouromper.model.vo.site.NoticiaVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.utils.Utils;

public class LuceneIndexer {

	public void indexar(DAOManager manager) {
		IndexWriterConfig config;
		IndexWriter w = null;

		try {

			String diretorio = new ParametroBe(manager).get(Constants.Parameters.PATH_LUCENE).getValor();

			// Limpar o diretorio
			DeleteDir.delete(diretorio);

			File fileDir = new File(diretorio);
			fileDir.mkdir();

			StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_48);

			Directory indexDirectory = new SimpleFSDirectory(fileDir);

			config = new IndexWriterConfig(Version.LUCENE_48, analyzer);

			w = new IndexWriter(indexDirectory, config);

			// Indexação dos objetos
			indexarNoticias(w, manager);
			indexarArtigos(w, manager);
			indexarProdutos(w, manager);
			indexarInstitucional(w, manager);
			indexarProfessor(w, manager);

			w.close();

			indexDirectory.close();

		} catch (IOException e) {
			if (w != null) {
				try {
					w.close();
				} catch (CorruptIndexException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} catch (ListException e) {
			if (w != null) {
				try {
					w.close();
				} catch (CorruptIndexException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}

	private void indexarNoticias(IndexWriter w, DAOManager manager) throws ListException, CorruptIndexException, IOException {
		List<NoticiaVo> list = new NoticiaBe(manager).getList();
		indexarLista(NoticiaVo.class, list, w);
	}

	private void indexarArtigos(IndexWriter w, DAOManager manager) throws ListException, CorruptIndexException, IOException {
		List<ArtigoVo> list = new ArtigoBe(manager).getList();
		indexarLista(ArtigoVo.class, list, w);
	}

	private void indexarProdutos(IndexWriter w, DAOManager manager) throws ListException, CorruptIndexException, IOException {
		List<ProdutoVo> list = new ProdutoBe(manager).getList();
		indexarLista(ProdutoVo.class, list, w);
	}

	private void indexarInstitucional(IndexWriter w, DAOManager manager) throws ListException, CorruptIndexException, IOException {
		List<InstitucionalVo> list = new InstitucionalBe(manager).getList();
		indexarLista(InstitucionalVo.class, list, w);
	}

	private void indexarProfessor(IndexWriter w, DAOManager manager) throws ListException, CorruptIndexException, IOException {
		List<ProfessorVo> list = new ProfessorBe(manager).getList();
		indexarLista(ProfessorVo.class, list, w);
	}

	private void indexarLista(Class<?> c, List<?> list, IndexWriter w) throws CorruptIndexException, IOException {
		for (Object i : list) {

			Document doc = new Document();

			String conteudoFull = "";

			// Cria um Field com o nome da classe
			doc.add(new org.apache.lucene.document.Field("className", c.getName(), TextField.TYPE_STORED));

			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);

				if (Modifier.isStatic(f.getModifiers())) {
					continue;
				}

				String fieldName = f.getName();

				Object objValor = null;

				try {
					objValor = f.get(i);
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {
				}

				if (objValor == null) {
					objValor = "";
				}

				conteudoFull += fieldName + " : " + Utils.removeAcentos(objValor.toString()) + ";";

				doc.add(new org.apache.lucene.document.Field(fieldName, objValor.toString(), TextField.TYPE_STORED));
			}

			doc.add(new org.apache.lucene.document.Field("ConteudoFull", conteudoFull, TextField.TYPE_STORED));

			w.addDocument(doc);
		}
	}

}
