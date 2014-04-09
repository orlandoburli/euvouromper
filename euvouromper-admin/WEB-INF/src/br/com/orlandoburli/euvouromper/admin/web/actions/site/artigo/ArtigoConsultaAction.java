package br.com.orlandoburli.euvouromper.admin.web.actions.site.artigo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.ArtigoBe;
import br.com.orlandoburli.euvouromper.model.dao.site.ArtigoDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.site.ArtigoVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class ArtigoConsultaAction extends BaseConsultaAction<ArtigoVo, ArtigoDao, ArtigoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/site/artigo/artigoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/site/artigo/artigoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Artigo.TABELA_ARTIGO+ "." + Dicionario.Artigo.Colunas.ID_ARTIGO + " DESC ";
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Artigos");
		getRequest().setAttribute("subtitulo", "Consulta de Artigos do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Artigos");
	}

	@Override
	public void doBeforeFilter(ArtigoVo filter, ArtigoBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdArtigo(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Titulo")) {
				filter.setTitulo("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setTitulo("%" + getPesquisarPor() + "%");
		}
	}

}
