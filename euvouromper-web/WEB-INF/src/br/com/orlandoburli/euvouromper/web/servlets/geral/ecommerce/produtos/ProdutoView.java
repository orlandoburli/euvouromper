package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.produtos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.be.online.ModuloBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ProdutoVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.model.vo.online.ModuloVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/produto.page")
public class ProdutoView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Menus

			WebUtils.buildMenus(req, manager);

			// Parametro da produto

			String parametroProduto = req.getParameter("produto");

			if (parametroProduto == null || parametroProduto.trim().equals("")) {
				resp.sendRedirect(req.getServletContext().getContextPath() + "/home");
				return;
			}

			// Produto

			ProdutoBe produtoBe = new ProdutoBe(manager);

			ProdutoVo produto = produtoBe.getByUrl(parametroProduto);

			// Modulos do Pacote
			if (produto.getTipoProduto().equals(TipoProduto.PACOTE)) {
				produto.getPacote().setModulos(new ModuloBe(manager).getByPacote(produto.getPacote()));

				// Busca o produto de cada modulo, se houver
				for (ModuloVo modulo : produto.getPacote().getModulos()) {
					modulo.setProduto(produtoBe.getByModulo(modulo));
				}
			}

			req.setAttribute("produto", produto);

			// Tipos de Produto

			WebUtils.sendDomain(req, new TipoProduto());

			// Ultimas Produtos

			// req.setAttribute("produtos", produtoBe.getPaginaProdutos(1));

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/ecommerce/produtos/produto_ver.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
