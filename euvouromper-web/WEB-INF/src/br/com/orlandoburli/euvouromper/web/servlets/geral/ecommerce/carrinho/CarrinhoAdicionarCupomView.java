package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.carrinho;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.PedidoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions.CupomBeException;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/carrinho.adicionar.cupom.page")
public class CarrinhoAdicionarCupomView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Adiciona um cupom de desconto ao carrinho

		String cupom = req.getParameter("cupom");

		PedidoVo pedido = (PedidoVo) req.getSession().getAttribute(Constants.Session.CARRINHO);

		DAOManager manager = DAOManager.getDAOManager();

		try {

			// Tenta adicionar o cupom
			new PedidoBe(manager).adicionarCupom(pedido, cupom);

		} catch (ListException | CupomBeException e) {
			req.setAttribute("erro", e.getMessage());
		}

		WebUtils.goTo(req, resp, "/carrinho");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
