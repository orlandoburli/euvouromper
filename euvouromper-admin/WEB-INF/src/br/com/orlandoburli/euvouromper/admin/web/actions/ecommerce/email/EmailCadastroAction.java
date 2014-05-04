package br.com.orlandoburli.euvouromper.admin.web.actions.ecommerce.email;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.EmailBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.EmailDao;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.EmailVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoEmail;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class EmailCadastroAction extends BaseCadastroAction<EmailVo, EmailDao, EmailBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/ecommerce/email/emailcadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, EmailVo vo, EmailBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		getRequest().setAttribute("titulo", "Cadastro de Emails");
		getRequest().setAttribute("subtitulo", "Cadastro de Emails do Site");
		getRequest().setAttribute("submenu", "e-Commerce");
		getRequest().setAttribute("menuAtivo", "Email");
		
		// Tipos de email (combo)
		getRequest().setAttribute("tipos", new TipoEmail().getList());
	}

}
