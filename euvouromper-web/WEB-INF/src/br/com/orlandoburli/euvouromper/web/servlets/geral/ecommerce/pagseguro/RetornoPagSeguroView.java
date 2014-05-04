package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.pagseguro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.PedidoBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/retornopagseguro")
public class RetornoPagSeguroView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Retorno automatico do pagseguro
		String notificationCode = req.getParameter("notificationCode");

		notificationCode = notificationCode == null ? req.getAttribute("notificationCode").toString() : notificationCode;

		DAOManager manager = DAOManager.getDAOManager();

		try {
			new PedidoBe(manager).checkByNotificationCode(notificationCode);
		} catch (BeException e) {
			Log.critical(e);
		} finally {
			manager.commit();
		}
	}
}
