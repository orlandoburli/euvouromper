package br.com.orlandoburli.euvouromper.web.servlets.geral.busca;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.euvouromper.web.servlets.utils.indexer.LuceneSearcher;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.vo.BaseVo;

@WebServlet(urlPatterns = { "/busca", "/buscar" })
public class BuscaView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		DAOManager manager = DAOManager.getDAOManager();

		String pesquisarPor = req.getParameter("s");

		try {
			pesquisarPor = pesquisarPor == null ? "" : pesquisarPor;

			// Menus

			WebUtils.buildMenus(req, manager);

			// Busca
			List<BaseVo> lista = new LuceneSearcher().buscar(pesquisarPor, manager);

			req.setAttribute("resultado", lista);

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}
		
		req.getRequestDispatcher("web/pages/busca/busca.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
