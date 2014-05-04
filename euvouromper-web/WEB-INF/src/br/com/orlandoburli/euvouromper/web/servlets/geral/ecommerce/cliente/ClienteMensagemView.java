package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.MensagemBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.MensagemLidaBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemVo;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/aluno/mensagem")
public class ClienteMensagemView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getSession().getAttribute(Constants.Session.CLIENTE) == null) {
			return;
		}

		Integer idMensagem = null;

		try {
			idMensagem = Integer.parseInt(req.getParameter("idMensagem"));
		} catch (NumberFormatException | NullPointerException e) {
			idMensagem = null;
		}

		if (idMensagem != null) {
			DAOManager manager = DAOManager.getDAOManager();
			try {
				ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);
				MensagemVo mensagem = new MensagemBe(manager).get(cliente, idMensagem);

				if (mensagem != null) {
					resp.getWriter().write(mensagem.getMensagem());

					new MensagemLidaBe(manager).lida(mensagem, cliente);
				}
			} catch (BeException e) {
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
