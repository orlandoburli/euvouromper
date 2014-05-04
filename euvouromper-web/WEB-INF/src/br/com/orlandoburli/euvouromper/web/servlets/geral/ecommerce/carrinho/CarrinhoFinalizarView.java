package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.carrinho;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.PedidoBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/carrinho/finalizar")
public class CarrinhoFinalizarView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		DAOManager manager = DAOManager.getDAOManager();

		try {

			WebUtils.buildMenus(req, manager);

			ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

			if (cliente == null) {
				WebUtils.goTo(req, resp, "/entrar?redir=/carrinho/finalizar");
				return;
			}

			PedidoVo carrinho = (PedidoVo) req.getSession().getAttribute(Constants.Session.CARRINHO);

			// Copia dados do cliente para o pedido
			carrinho.setCliente(cliente);
			carrinho.setIdCliente(cliente.getIdCliente());
			carrinho.setNome(cliente.getNome());
			carrinho.setEmail(cliente.getEmail());
			carrinho.setCpf(cliente.getCpf());
			carrinho.setCep(cliente.getCep());
			carrinho.setEndereco(cliente.getEndereco());
			carrinho.setNumero(cliente.getNumero());
			carrinho.setBairro(cliente.getBairro());
			carrinho.setComplemento(cliente.getComplemento());
			carrinho.setUf(cliente.getUf());
			carrinho.setCidade(cliente.getCidade());
			carrinho.setFone1(cliente.getFone1());
			carrinho.setFone2(cliente.getFone2());

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("../web/pages/ecommerce/carrinho/finalizar.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PedidoVo carrinho = (PedidoVo) req.getSession().getAttribute(Constants.Session.CARRINHO);

		if (carrinho == null) {
			WebUtils.goHome(req, resp);
			return;
		}

		carrinho.setNome(req.getParameter("nome"));
		carrinho.setCpf(req.getParameter("cpf"));
		carrinho.setCep(req.getParameter("cep"));
		carrinho.setEndereco(req.getParameter("endereco"));
		try {
			carrinho.setNumero(Integer.parseInt(req.getParameter("numero")));
		} catch (NumberFormatException e) {
		}
		carrinho.setBairro(req.getParameter("bairro"));
		carrinho.setComplemento(req.getParameter("complemento"));
		carrinho.setUf(req.getParameter("uf"));
		carrinho.setCidade(req.getParameter("cidade"));
		carrinho.setFone1(req.getParameter("fone1"));
		carrinho.setFone2(req.getParameter("fone2"));

		DAOManager manager = DAOManager.getDAOManager();

		try {
			new PedidoBe(manager).finalizar(carrinho);

			// Remove o carrinho da sessao
			req.getSession().removeAttribute(Constants.Session.CARRINHO);

			WebUtils.goTo(req, resp, "/aluno/pedidos");
		} catch (BeException e) {
			manager.rollback();
			req.setAttribute("erro", e.getMessage());
			req.getRequestDispatcher("../web/pages/ecommerce/carrinho/finalizar.jsp").forward(req, resp);
		} finally {
			manager.commit();
		}
	}
}
