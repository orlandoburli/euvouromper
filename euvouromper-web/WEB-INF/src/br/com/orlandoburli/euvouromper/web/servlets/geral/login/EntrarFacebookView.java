package br.com.orlandoburli.euvouromper.web.servlets.geral.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente.ClienteBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

public class EntrarFacebookView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {
			String token = req.getParameter("token");

			if (token != null) {
				// Login com facebook

				FacebookClient facebookClient = new DefaultFacebookClient(token);
				User facebookUser = facebookClient.fetchObject("me", User.class);

				try {
					ClienteVo cliente = new ClienteBe(manager).loginFacebook(facebookUser.getName(), facebookUser.getEmail());

					if (cliente != null) {
						req.getSession().setAttribute("cliente", cliente);
						WebUtils.goHome(req, resp);
					}
				} catch (BeException e) {
					Log.error(e);
				}
			}
		} finally {
			manager.commit();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
