package br.com.orlandoburli.euvouromper.web.servlets.geral.site.newsletter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.NewsletterBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.DeleteBeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/remover")
public class RemoverView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");

		if (email != null && !email.trim().equals("")) {
			DAOManager manager = DAOManager.getDAOManager();
			try {
				new NewsletterBe(manager).remover(email);
			} catch (ListException | DeleteBeException e) {
				Log.error(e);
			} finally {
				manager.commit();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
