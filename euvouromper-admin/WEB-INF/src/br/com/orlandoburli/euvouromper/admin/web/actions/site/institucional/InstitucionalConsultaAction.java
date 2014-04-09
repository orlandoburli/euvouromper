package br.com.orlandoburli.euvouromper.admin.web.actions.site.institucional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.InstitucionalBe;
import br.com.orlandoburli.euvouromper.model.dao.site.InstitucionalDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.site.InstitucionalVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class InstitucionalConsultaAction extends BaseConsultaAction<InstitucionalVo, InstitucionalDao, InstitucionalBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/site/institucional/institucionalconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/site/institucional/institucionalconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Institucional.TABELA_INSTITUCIONAL + "." + Dicionario.Institucional.Colunas.TITULO;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Páginas Institucionais");
		getRequest().setAttribute("subtitulo", "Consulta de Páginas Institucionais do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Páginas Institucionais");
	}

	@Override
	public void doBeforeFilter(InstitucionalVo filter, InstitucionalBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdInstitucional(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setTitulo("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setTitulo("%" + getPesquisarPor() + "%");
		}
	}

}
