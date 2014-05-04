package br.com.orlandoburli.euvouromper.admin.web.actions.ecommerce.email;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.EmailBe;
import br.com.orlandoburli.euvouromper.model.dao.ecommerce.EmailDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.EmailVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class EmailConsultaAction extends BaseConsultaAction<EmailVo, EmailDao, EmailBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/ecommerce/email/emailconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/ecommerce/email/emailconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Email.TABELA_EMAIL + "." + Dicionario.Email.Colunas.ID_EMAIL;
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Emails");
		getRequest().setAttribute("subtitulo", "Consulta de Emails do Site");
		getRequest().setAttribute("submenu", "e-Commerce");
		getRequest().setAttribute("menuAtivo", "Emails");
	}

	@Override
	public void doBeforeFilter(EmailVo filter, EmailBe be, HttpServletRequest request, HttpServletResponse response) {
		filter.setIdEmail(getPesquisarPor() + "%");
	}

}
