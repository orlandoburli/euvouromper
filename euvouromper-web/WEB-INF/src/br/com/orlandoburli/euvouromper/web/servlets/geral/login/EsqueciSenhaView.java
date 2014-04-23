package br.com.orlandoburli.euvouromper.web.servlets.geral.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ClienteBe;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/esqueci_a_senha")
public class EsqueciSenhaView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Menus

			WebUtils.buildMenus(req, manager);

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/login/esqueci_a_senha.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		
		DAOManager manager = DAOManager.getDAOManager();
		
		try {
			
			new ClienteBe(manager).resetarSenha(email);
			
			req.setAttribute("sucesso", "Uma nova senha foi enviada para o email " + email + ". Confira a sua caixa de entrada." );
			
		} catch (BeException e) {
			req.setAttribute("erro", e.getMessage());
		} finally {
			manager.commit();
		}
		
		doGet(req, resp);
	}
}
