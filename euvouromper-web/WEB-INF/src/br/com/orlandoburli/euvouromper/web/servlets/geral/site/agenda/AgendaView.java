package br.com.orlandoburli.euvouromper.web.servlets.geral.site.agenda;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.AgendaBe;
import br.com.orlandoburli.euvouromper.model.vo.site.AgendaVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/agenda.page")
public class AgendaView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Menus

			WebUtils.buildMenus(req, manager);

			// Parametro da agenda

			String parametroAgenda = req.getParameter("agenda");

			if (parametroAgenda == null || parametroAgenda.trim().equals("")) {
				resp.sendRedirect(req.getServletContext().getContextPath() + "/home");
				return;
			}

			// Agenda

			AgendaBe agendaBe = new AgendaBe(manager);

			AgendaVo agenda = agendaBe.getByUrl(parametroAgenda);

			req.setAttribute("agenda", agenda);

			// Ultimas Agendas

			req.setAttribute("agendas", agendaBe.getPaginaAgendas(1));

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/site/agenda/agenda_ver.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
