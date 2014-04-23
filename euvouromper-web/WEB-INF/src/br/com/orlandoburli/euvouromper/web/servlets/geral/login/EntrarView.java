package br.com.orlandoburli.euvouromper.web.servlets.geral.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.admin.LoginInvalidoException;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.ClienteBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/entrar")
public class EntrarView extends HttpServlet {

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

		req.getRequestDispatcher("web/pages/login/entrar.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {

			if (req.getParameter("btnEntrar") != null) {

				// Ação de login
				String email = req.getParameter("email");
				String senha = req.getParameter("senha");
				String redir = req.getParameter("redir");

				try {
					ClienteVo cliente = new ClienteBe(manager).login(email, senha);

					if (cliente != null) {
						req.getSession().setAttribute("cliente", cliente);
					}

					if (redir != null) {
						WebUtils.goTo(req, resp, redir);
					} else {
						WebUtils.goHome(req, resp);
					}
					return;

				} catch (ListException e) {
					Log.error(e);
					req.setAttribute("erroLogin", e.getMessage());
					doGet(req, resp);
				} catch (LoginInvalidoException e) {
					req.setAttribute("l_email", email);
					req.setAttribute("erroLogin", e.getMessage());
					doGet(req, resp);
				}
			} else if (req.getParameter("btnCadastrar") != null) {
				// Ação de cadastro
				String nome = req.getParameter("nome");
				String email = req.getParameter("email");
				String senha = req.getParameter("senha");
				String confSenha = req.getParameter("confSenha");
				String redir = req.getParameter("redir");

				try {
					ClienteVo cliente = new ClienteBe(manager).cadastrar(nome, email, senha, confSenha);

					if (cliente != null) {
						req.getSession().setAttribute("cliente", cliente);
					}

					if (redir != null) {
						WebUtils.goTo(req, resp, redir);
					} else {
						WebUtils.goHome(req, resp);
					}

					return;

				} catch (BeException e) {
					req.setAttribute("c_nome", nome);
					req.setAttribute("c_email", email);
					req.setAttribute("erroCadastro", e.getMessage());
					doGet(req, resp);
				}
			}

		} finally {
			manager.commit();
		}
	}
}
