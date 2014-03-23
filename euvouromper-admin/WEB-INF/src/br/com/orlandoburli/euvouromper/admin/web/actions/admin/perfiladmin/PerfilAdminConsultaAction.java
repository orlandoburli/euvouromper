package br.com.orlandoburli.euvouromper.admin.web.actions.admin.perfiladmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.admin.PerfilAdminBe;
import br.com.orlandoburli.euvouromper.model.dao.admin.PerfilAdminDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.admin.PerfilAdminVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class PerfilAdminConsultaAction extends BaseConsultaAction<PerfilAdminVo, PerfilAdminDao, PerfilAdminBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/admin/perfiladmin/perfiladminconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/admin/perfiladmin/perfiladminconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.PerfilAdmin.Colunas.NOME;
	}
	
	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Perfis");
		getRequest().setAttribute("subtitulo", "Consulta de Perfis de Acesso do Painel de Administração");
		getRequest().setAttribute("submenu", "Administração");
		getRequest().setAttribute("menuAtivo", "Perfis");
	}

	@Override
	public void doBeforeFilter(PerfilAdminVo filter, PerfilAdminBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {}
				filter.setIdPerfil(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}
