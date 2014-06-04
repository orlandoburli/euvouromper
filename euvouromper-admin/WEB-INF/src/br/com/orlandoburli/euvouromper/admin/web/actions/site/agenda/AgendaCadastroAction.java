package br.com.orlandoburli.euvouromper.admin.web.actions.site.agenda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.AgendaBe;
import br.com.orlandoburli.euvouromper.model.dao.site.AgendaDao;
import br.com.orlandoburli.euvouromper.model.vo.site.AgendaVo;
import br.com.orlandoburli.euvouromper.model.vo.site.StatusAgenda;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;

public class AgendaCadastroAction extends BaseCadastroAction<AgendaVo, AgendaDao, AgendaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/site/agenda/agendacadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, AgendaVo vo, AgendaBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Cadastro de Agenda");
		getRequest().setAttribute("subtitulo", "Cadastro de Agenda do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Agenda");

		getRequest().setAttribute("statusAgendaList", new StatusAgenda().getList());
	}
}
