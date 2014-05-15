package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.MensagemLidaBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.PedidoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente.ClienteBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.StatusPedido;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/aluno/pedidos")
public class ClientePedidosView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null) {
			WebUtils.goTo(req, resp, "/entrar?redir=/aluno/pedidos");
			return;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {

			// Menus

			WebUtils.buildMenus(req, manager);

			// Lista de Pedidos

			req.setAttribute("pedidos", new PedidoBe(manager).getList(cliente));

			// Status dos pedidos

			WebUtils.sendDomain(req, new StatusPedido());

			// Novas Mensagens

			req.setAttribute("novasMensagens", new MensagemLidaBe(manager).getNovasMensagensCount(cliente));

			// Saldo

			req.setAttribute("saldo", new ClienteBe(manager).saldo(cliente));

		} catch (BeException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("../web/pages/ecommerce/cliente/cliente_pedido_list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
