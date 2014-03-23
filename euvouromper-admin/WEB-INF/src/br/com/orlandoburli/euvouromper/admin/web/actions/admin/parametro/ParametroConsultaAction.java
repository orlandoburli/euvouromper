package br.com.orlandoburli.euvouromper.admin.web.actions.admin.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.admin.ParametroBe;
import br.com.orlandoburli.euvouromper.model.dao.admin.ParametroDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.admin.ParametroVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class ParametroConsultaAction extends BaseConsultaAction<ParametroVo, ParametroDao, ParametroBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/admin/parametro/parametroconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/admin/parametro/parametroconsulta_grid.jsp";
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Parâmetros");
		getRequest().setAttribute("subtitulo", "Consulta de Parâmetros do Painel de Administração");
		getRequest().setAttribute("submenu", "Administração");
		getRequest().setAttribute("menuAtivo", "Parâmetros");
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Parametro.TABELA_PARAMETRO + "." + Dicionario.Parametro.Colunas.ID_PARAMETRO;
	}

	@Override
	public void doBeforeFilter(ParametroVo filter, ParametroBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				filter.setIdParametro("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}
