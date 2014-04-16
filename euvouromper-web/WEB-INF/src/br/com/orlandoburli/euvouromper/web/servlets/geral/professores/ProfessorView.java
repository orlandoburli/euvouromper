package br.com.orlandoburli.euvouromper.web.servlets.geral.professores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.cadastros.ProfessorBe;
import br.com.orlandoburli.euvouromper.model.be.site.MenuBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;

@WebServlet("/professor.page")
public class ProfessorView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Menus

			MenuBe menuBe = new MenuBe(manager);

			req.setAttribute("menusTopo", menuBe.getListTopo());
			req.setAttribute("menusRodape1", menuBe.getListRodape1());
			req.setAttribute("menusRodape2", menuBe.getListRodape2());

			// Professor
			
			String professorParametro = req.getParameter("professor");

			req.setAttribute("professor", new ProfessorBe(manager).getByUrl(professorParametro));

		} catch (ListException e) {
			e.printStackTrace();
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/site/professores/professor_ver.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
