package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.ArtigoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Artigo;
import br.com.orlandoburli.euvouromper.model.vo.site.ArtigoVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusArtigo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ArtigoBe extends BaseBe<ArtigoVo, ArtigoDao> {

	private static final int TAMANHO_PAGINA_ARTIGOS = 10;

	public ArtigoBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(ArtigoVo vo) throws br.com.orlandoburli.framework.core.be.exceptions.BeException {
		if (vo.getTitulo() != null && !vo.getTitulo().trim().equals("")) {
			vo.setUrl(vo.getTitulo().toLowerCase());
		}

		super.doBeforeSave(vo);
	};

	public ArtigoVo getByUrl(String url) throws ListException {
		ArtigoVo filter = new ArtigoVo();

		filter.setUrl(url);
		filter.setStatus(StatusArtigo.PUBLICADO);

		List<ArtigoVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public List<ArtigoVo> getListaHome() throws ListException {

		ArtigoVo filter = new ArtigoVo();

		filter.setStatus(StatusArtigo.PUBLICADO);

		return getList(filter, null, Artigo.TABELA_ARTIGO + "." + Artigo.Colunas.DATA + " DESC", 1, 3);
	}

	public Integer getQuantidadePaginasArtigos() throws ListException {

		ArtigoVo filter = new ArtigoVo();

		filter.setStatus(StatusArtigo.PUBLICADO);

		return getPageCount(filter, null, TAMANHO_PAGINA_ARTIGOS);
	}

	public List<ArtigoVo> getPaginaArtigos(Integer pagina) throws ListException {

		ArtigoVo filter = new ArtigoVo();

		filter.setStatus(StatusArtigo.PUBLICADO);

		return getList(filter, null, Artigo.TABELA_ARTIGO + "." + Artigo.Colunas.DATA + " DESC", pagina, TAMANHO_PAGINA_ARTIGOS);
	}
}
