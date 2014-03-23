package br.com.orlandoburli.euvouromper.admin.web.actions.admin.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.admin.PerfilAdminBe;
import br.com.orlandoburli.euvouromper.model.be.admin.UsuarioBe;
import br.com.orlandoburli.euvouromper.model.dao.admin.UsuarioDao;
import br.com.orlandoburli.euvouromper.model.vo.admin.UsuarioVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class UsuarioCadastroAction extends BaseCadastroAction<UsuarioVo, UsuarioDao, UsuarioBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/admin/usuario/usuariocadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, UsuarioVo vo, UsuarioBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Usuários");
		getRequest().setAttribute("subtitulo", "Cadastro de Usuários do Painel de Administração");
		getRequest().setAttribute("submenu", "Administração");
		getRequest().setAttribute("menuAtivo", "Usuários");

		PerfilAdminBe perfilBe = new PerfilAdminBe(manager);
		
		try {
			request.setAttribute("perfis",  perfilBe.getList());
		} catch (ListException e) {
			e.printStackTrace();
		}
	}
}
