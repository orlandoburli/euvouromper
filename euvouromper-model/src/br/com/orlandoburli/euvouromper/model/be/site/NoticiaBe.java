package br.com.orlandoburli.euvouromper.model.be.site;

import java.util.List;

import br.com.orlandoburli.euvouromper.model.dao.site.NoticiaDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario.Noticia;
import br.com.orlandoburli.euvouromper.model.vo.site.NoticiaVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusNoticia;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class NoticiaBe extends BaseBe<NoticiaVo, NoticiaDao> {

	private static final Integer TAMANHO_PAGINA_NOTICIAS = 6;

	public NoticiaBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(NoticiaVo vo) throws BeException {
		if (vo.getTitulo() != null && !vo.getTitulo().trim().equals("")) {
			vo.setUrl(vo.getTitulo().toLowerCase());
		}

		super.doBeforeSave(vo);
	}

	public NoticiaVo getByUrl(String url) throws ListException {
		NoticiaVo filter = new NoticiaVo();

		filter.setUrl(url);
		filter.setStatus(StatusNoticia.PUBLICADO);

		List<NoticiaVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public List<NoticiaVo> getListaHome() throws ListException {
		NoticiaVo filter = new NoticiaVo();
		filter.setStatus(StatusNoticia.PUBLICADO);

		return getList(filter, null, Noticia.TABELA_NOTICIA + "." + Noticia.Colunas.DATA + " DESC", 1, 2);
	}

	/**
	 * Retorna a lista de noticias de uma pagina
	 * 
	 * @param pagina
	 *            Numero da pagina
	 * @return Lista com as noticias
	 * @throws ListException
	 */
	public List<NoticiaVo> getPaginaNoticias(int pagina) throws ListException {

		NoticiaVo filter = new NoticiaVo();

		filter.setStatus(StatusNoticia.PUBLICADO);

		return getList(filter, null, Noticia.TABELA_NOTICIA + "." + Noticia.Colunas.DATA + " DESC", pagina, TAMANHO_PAGINA_NOTICIAS);
	}

	/**
	 * Retorna o numero de paginas
	 * @return Numero de paginas de noticias
	 * @throws ListException
	 */
	public Integer getQuantidadePaginasNoticias() throws ListException {

		NoticiaVo filter = new NoticiaVo();

		filter.setStatus(StatusNoticia.PUBLICADO);

		return getPageCount(filter, null, TAMANHO_PAGINA_NOTICIAS);
	}

}
