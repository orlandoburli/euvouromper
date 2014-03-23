package br.com.orlandoburli.euvouromper.admin.web.actions.admin.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.admin.UsuarioBe;
import br.com.orlandoburli.euvouromper.model.dao.admin.UsuarioDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.admin.UsuarioVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class UsuarioConsultaAction extends BaseConsultaAction<UsuarioVo, UsuarioDao, UsuarioBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/admin/usuario/usuarioconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/admin/usuario/usuarioconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Usuario.TABELA_USUARIO + "." + Dicionario.Usuario.Colunas.NOME;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Usuários");
		getRequest().setAttribute("subtitulo", "Consulta de Usuários do Painel de Administração");
		getRequest().setAttribute("submenu", "Administração");
		getRequest().setAttribute("menuAtivo", "Usuários");
	}

	@Override
	public void doBeforeFilter(UsuarioVo filter, UsuarioBe be, HttpServletRequest request, HttpServletResponse response) {

		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdUsuario(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}
