package br.com.orlandoburli.euvouromper.web.servlets.geral.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;

@WebServlet("/sair")
public class SairView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Logoff do aluno
		req.getSession().removeAttribute("cliente");

		String redir = req.getParameter("redir");

		if (redir != null) {
			WebUtils.goTo(req, resp, redir);
		} else {
			WebUtils.goHome(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
