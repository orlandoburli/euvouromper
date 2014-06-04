package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.produtos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.ecommerce.ProdutoBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.TipoProduto;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/produto.lista.page")
public class ProdutoList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Tipos de produto

		WebUtils.sendDomain(req, new TipoProduto());

		Integer pagina = 1;

		String tipo = null;

		if (req.getParameter("pagina") != null) {
			if (req.getParameter("pagina").equals("modulo")) {
				tipo = TipoProduto.MODULO;
			} else if (req.getParameter("pagina").equals("pacote")) {
				tipo = TipoProduto.PACOTE;
			} else if (req.getParameter("pagina").equals("full")) {
				tipo = TipoProduto.TOTAL;
			} else if (req.getParameter("pagina").equals("credito")) {
				tipo = TipoProduto.CREDITO;
			}
		}

		try {
			pagina = Integer.parseInt(req.getParameter("pagina"));
		} catch (NumberFormatException e) {
			pagina = 1;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Menus

			WebUtils.buildMenus(req, manager);

			// Produtos

			ProdutoBe produtoBe = new ProdutoBe(manager);

			Integer totalPaginas = produtoBe.getQuantidadePaginasProdutos();

			req.setAttribute("produtos", produtoBe.getPaginaProdutos(pagina, tipo));

			Integer paginaAnterior = pagina > 1 ? pagina - 1 : 1;
			Integer proximaPagina = pagina >= totalPaginas ? pagina : pagina + 1;
			Integer ultimaPagina = totalPaginas;

			req.setAttribute("paginaAnterior", paginaAnterior);
			req.setAttribute("proximaPagina", proximaPagina);
			req.setAttribute("ultimaPagina", ultimaPagina);
			req.setAttribute("tipo", tipo);

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/ecommerce/produtos/produto_lista.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
