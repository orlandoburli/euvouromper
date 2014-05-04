package br.com.orlandoburli.euvouromper.admin.web.actions.site.departamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.DepartamentoBe;
import br.com.orlandoburli.euvouromper.model.dao.site.DepartamentoDao;
import br.com.orlandoburli.euvouromper.model.vo.site.DepartamentoVo;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class DepartamentoCadastroAction extends BaseCadastroAction<DepartamentoVo, DepartamentoDao, DepartamentoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/site/departamento/departamentocadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, DepartamentoVo vo, DepartamentoBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Departamentos");
		getRequest().setAttribute("subtitulo", "Cadastro de Departamentos do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Departamento");
	}

}
