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
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/carrinho.adicionar.page")
public class CarrinhoAdicionarView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String produto = req.getParameter("produto");

		DAOManager manager = DAOManager.getDAOManager();

		try {
			Integer idProduto = Integer.parseInt(produto);

			PedidoVo pedido = (PedidoVo) req.getSession().getAttribute("carrinho");

			if (pedido == null) {
				pedido = new PedidoVo();
			}

			new PedidoBe(manager).adicionarItem(pedido, idProduto);

			req.getSession().setAttribute(Constants.Session.CARRINHO, pedido);

		} catch (NumberFormatException e) {
			Log.info(e);
		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		WebUtils.goTo(req, resp, "carrinho");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
