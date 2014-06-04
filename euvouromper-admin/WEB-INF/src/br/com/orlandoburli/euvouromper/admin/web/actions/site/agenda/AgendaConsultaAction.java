package br.com.orlandoburli.euvouromper.admin.web.actions.site.agenda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.AgendaBe;
import br.com.orlandoburli.euvouromper.model.dao.site.AgendaDao;
import br.com.orlandoburli.euvouromper.model.utils.Dicionario;
import br.com.orlandoburli.euvouromper.model.vo.site.AgendaVo;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;

public class AgendaConsultaAction extends BaseConsultaAction<AgendaVo, AgendaDao, AgendaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/site/agenda/agendaconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/site/agenda/agendaconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Agenda.TABELA_AGENDA + "." + Dicionario.Agenda.Colunas.ID_AGENDA + " DESC ";
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();
		getRequest().setAttribute("titulo", "Consulta de Agendas");
		getRequest().setAttribute("subtitulo", "Consulta de Agendas do Site");
		getRequest().setAttribute("submenu", "Site");
		getRequest().setAttribute("menuAtivo", "Agendas");
	}

	@Override
	public void doBeforeFilter(AgendaVo filter, AgendaBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdAgenda(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setTitulo("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setTitulo("%" + getPesquisarPor() + "%");
		}
	}

}
