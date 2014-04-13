package br.com.orlandoburli.euvouromper.web.servlets.geral;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.ArtigoBe;
import br.com.orlandoburli.euvouromper.model.vo.site.ArtigoVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

public class ArtigoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {
			String url = req.getParameter("url");

			if (url == null || url.trim().equals("")) {
				resp.sendRedirect(req.getServletContext().getContextPath() + "/home");
				return;
			}
			
			ArtigoVo artigo = new ArtigoBe(manager).getByUrl(url);

			req.setAttribute("artigo", artigo);

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
