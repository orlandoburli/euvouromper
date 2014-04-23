package br.com.orlandoburli.euvouromper.web.servlets.geral.site.artigos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.ArtigoBe;
import br.com.orlandoburli.euvouromper.model.vo.site.ArtigoVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/artigo.page")
public class ArtigoView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Menus

			WebUtils.buildMenus(req, manager);

			// Parametro da artigo

			String parametroArtigo = req.getParameter("artigo");

			if (parametroArtigo == null || parametroArtigo.trim().equals("")) {
				resp.sendRedirect(req.getServletContext().getContextPath() + "/home");
				return;
			}

			// Artigo

			ArtigoBe artigoBe = new ArtigoBe(manager);

			ArtigoVo artigo = artigoBe.getByUrl(parametroArtigo);

			req.setAttribute("artigo", artigo);

			// Ultimas Artigos

			req.setAttribute("artigos", artigoBe.getPaginaArtigos(1));

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/site/artigos/artigo_ver.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
