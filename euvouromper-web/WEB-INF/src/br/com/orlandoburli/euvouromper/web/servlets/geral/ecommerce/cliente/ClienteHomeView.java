package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.MensagemBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.PedidoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente.ClienteBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.cliente.LogVideoBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.MensagemVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente.ClienteVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/aluno")
public class ClienteHomeView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null) {
			WebUtils.goTo(req, resp, "/entrar?redir=/aluno");
			return;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {

			// Menus

			WebUtils.buildMenus(req, manager);

			// Saldo 
			
			req.setAttribute("saldo", new ClienteBe(manager).saldo(cliente));

			// Pedidos em aberto
			req.setAttribute("pedidosAbertos", new PedidoBe(manager).getPedidosAbertos(cliente));

			// TODO Ultimas aulas
			req.setAttribute("ultimasAulas", new LogVideoBe(manager).getUltimasAulas());

			// Mensagens

			List<MensagemVo> mensagens = new MensagemBe(manager).getList(cliente, 10);

			int novasMensagens = 0;
			for (MensagemVo mensagem : mensagens) {
				if (!mensagem.isLida()) {
					novasMensagens++;
				}
			}

			req.setAttribute("novasMensagens", novasMensagens);

			// Remove deixando somente as 3 primeiras
			int max = mensagens.size() > 3 ? 3 : mensagens.size();
			mensagens = mensagens.subList(0, max);

			req.setAttribute("mensagens", mensagens);

		} catch (BeException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/ecommerce/cliente/cliente_home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}