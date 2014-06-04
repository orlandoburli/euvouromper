package br.com.orlandoburli.euvouromper.web.servlets.geral.site.agenda;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.AgendaBe;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/agenda.lista.page")
public class AgendaList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer pagina = 1;

		try {
			pagina = Integer.parseInt(req.getParameter("pagina"));
		} catch (NumberFormatException e) {
			pagina = 1;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Menus

			WebUtils.buildMenus(req, manager);

			// Not??cias
			
			AgendaBe agendaBe = new AgendaBe(manager);

			Integer totalPaginas = agendaBe.getQuantidadePaginasAgendas();

			req.setAttribute("agendas", agendaBe.getPaginaAgendas(pagina));

			Integer paginaAnterior = pagina > 1 ? pagina - 1 : 1;
			Integer proximaPagina = pagina >= totalPaginas ? pagina : pagina + 1;
			Integer ultimaPagina = totalPaginas;

			req.setAttribute("paginaAnterior", paginaAnterior);
			req.setAttribute("proximaPagina", proximaPagina);
			req.setAttribute("ultimaPagina", ultimaPagina);

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/site/agenda/agenda_lista.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
