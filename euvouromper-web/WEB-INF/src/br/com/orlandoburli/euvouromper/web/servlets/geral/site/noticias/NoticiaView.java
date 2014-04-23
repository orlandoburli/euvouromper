package br.com.orlandoburli.euvouromper.web.servlets.geral.site.noticias;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.NoticiaBe;
import br.com.orlandoburli.euvouromper.model.vo.site.NoticiaVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/noticia.page")
public class NoticiaView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Menus

			WebUtils.buildMenus(req, manager);

			// Parametro da noticia

			String parametroNoticia = req.getParameter("noticia");

			if (parametroNoticia == null || parametroNoticia.trim().equals("")) {
				resp.sendRedirect(req.getServletContext().getContextPath() + "/home");
				return;
			}

			// Noticia

			NoticiaBe noticiaBe = new NoticiaBe(manager);

			NoticiaVo noticia = noticiaBe.getByUrl(parametroNoticia);

			req.setAttribute("noticia", noticia);

			// Ultimas Noticias

			req.setAttribute("noticias", noticiaBe.getPaginaNoticias(1));

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/site/noticias/noticia_ver.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
