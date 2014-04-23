package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.carrinho;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.PedidoBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/carrinho.cupom.remover.page")
public class CarrinhoRemoverCupomView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Remove o cupom de desconto
		PedidoVo pedido = (PedidoVo) req.getSession().getAttribute(Constants.Session.CARRINHO);

		DAOManager manager = DAOManager.getDAOManager();
		try {
			new PedidoBe(manager).removerCupom(pedido);
		} finally {
			manager.commit();
		}

		WebUtils.goTo(req, resp, "/carrinho");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
