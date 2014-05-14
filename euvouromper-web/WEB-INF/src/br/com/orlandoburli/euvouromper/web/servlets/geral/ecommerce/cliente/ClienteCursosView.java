package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ClienteBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.ItemPedidoBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.MensagemLidaBe;
import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;

@WebServlet("/aluno/cursos")
public class ClienteCursosView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

		if (cliente == null) {
			WebUtils.goTo(req, resp, "/entrar?redir=/aluno/cursos");
			return;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {

			// Menus

			WebUtils.buildMenus(req, manager);

			// Novas Mensagens

			req.setAttribute("novasMensagens", new MensagemLidaBe(manager).getNovasMensagensCount(cliente));

			// Saldo

			req.setAttribute("saldo", new ClienteBe(manager).saldo(cliente));
			
			// Cursos / Produtos
			
			List<ProdutoVo> produtos = new ProdutoBe(manager).getListAtivos();
			
			// Verifica se o cliente já comprou algum destes itens
			new ItemPedidoBe(manager).checkComprado(produtos, cliente);
			
			req.setAttribute("produtos", produtos);
			
			// Tipos de produto
			
			WebUtils.sendDomain(req, new TipoProduto());

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("../web/pages/ecommerce/cliente/cliente_cursos.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
