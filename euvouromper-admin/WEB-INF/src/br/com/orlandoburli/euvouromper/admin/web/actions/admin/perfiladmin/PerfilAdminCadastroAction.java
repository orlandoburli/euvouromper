package br.com.orlandoburli.euvouromper.admin.web.actions.admin.perfiladmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.admin.PerfilAdminBe;
import br.com.orlandoburli.euvouromper.model.dao.admin.PerfilAdminDao;
import br.com.orlandoburli.euvouromper.model.vo.admin.PerfilAdminVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class PerfilAdminCadastroAction extends BaseCadastroAction<PerfilAdminVo, PerfilAdminDao, PerfilAdminBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/admin/perfiladmin/perfiladmincadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, PerfilAdminVo vo, PerfilAdminBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Perfis");
		getRequest().setAttribute("subtitulo", "Cadastro de Perfis de Acesso do Painel de Administração");
		getRequest().setAttribute("submenu", "Administração");
		getRequest().setAttribute("menuAtivo", "Perfis");
	}

}
