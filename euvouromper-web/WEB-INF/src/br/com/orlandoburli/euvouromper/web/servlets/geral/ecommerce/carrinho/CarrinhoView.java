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
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoDesconto;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/carrinho")
public class CarrinhoView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DAOManager manager = DAOManager.getDAOManager();

		try {
			WebUtils.buildMenus(req, manager);
		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		// Se chegar ate aqui sem estar logado, redireciona para o login
		if (req.getSession().getAttribute(Constants.Session.CLIENTE) == null) {
			WebUtils.goTo(req, resp, "/entrar?redir=/carrinho");
			return;
		}
		
		//  Envia o tipo de desconto para a pagina
		WebUtils.sendDomain(req, new TipoDesconto());

		req.getRequestDispatcher("web/pages/ecommerce/carrinho/carrinho.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cupom = req.getParameter("cupom");

		if (cupom != null) {
			// Adiciona um cupom de desconto ao carrinho

			PedidoVo pedido = (PedidoVo) req.getSession().getAttribute(Constants.Session.CARRINHO);

			DAOManager manager = DAOManager.getDAOManager();

			try {

				// Tenta adicionar o cupom
				new PedidoBe(manager).adicionarCupom(pedido, cupom);

			} catch (ListException | CupomBeException e) {
				req.setAttribute("erro", e.getMessage());
			}
		}

		doGet(req, resp);
	}
}
