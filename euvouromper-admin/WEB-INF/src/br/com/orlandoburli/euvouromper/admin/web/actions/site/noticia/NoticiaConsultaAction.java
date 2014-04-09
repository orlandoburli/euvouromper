package br.com.orlandoburli.euvouromper.admin.web.actions.site.noticia;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.NoticiaBe;
import br.com.orlandoburli.euvouromper.model.dao.site.NoticiaDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.site.NoticiaVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class NoticiaConsultaAction extends BaseConsultaAction<NoticiaVo, NoticiaDao, NoticiaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/site/noticia/noticiaconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/site/noticia/noticiaconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Noticia.TABELA_NOTICIA + "." + Dicionario.Noticia.Colunas.ID_NOTICIA + " DESC ";
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Noticias");
		getRequest().setAttribute("subtitulo", "Consulta de Noticias do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Noticias");
	}

	@Override
	public void doBeforeFilter(NoticiaVo filter, NoticiaBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdNoticia(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setTitulo("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setTitulo("%" + getPesquisarPor() + "%");
		}
	}

}
