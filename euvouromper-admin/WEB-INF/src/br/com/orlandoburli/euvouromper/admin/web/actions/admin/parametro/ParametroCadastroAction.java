package br.com.orlandoburli.euvouromper.admin.web.actions.admin.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.admin.ParametroBe;
import br.com.orlandoburli.euvouromper.model.dao.admin.ParametroDao;
import br.com.orlandoburli.euvouromper.model.vo.admin.ParametroVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class ParametroCadastroAction extends BaseCadastroAction<ParametroVo, ParametroDao, ParametroBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/admin/parametro/parametrocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, ParametroVo vo, ParametroBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Parâmetros");
		getRequest().setAttribute("subtitulo", "Cadastro de Parâmetros do Painel de Administração");
		getRequest().setAttribute("submenu", "Administração");
		getRequest().setAttribute("menuAtivo", "Parâmetros");
	}
}
