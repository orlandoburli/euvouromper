package br.com.orlandoburli.euvouromper.web.servlets.geral.noticias;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.MenuBe;
import br.com.orlandoburli.euvouromper.model.be.site.NoticiaBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/noticia.lista.page")
public class NoticiaList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer pagina = 1;

		try {
			pagina = Integer.parseInt(req.getParameter("pagina"));
		} catch (NumberFormatException e) {
			pagina = 1;
		}

		DAOManager manager = DAOManager.getDAOManager();

		try {
			// Menus

			MenuBe menuBe = new MenuBe(manager);

			req.setAttribute("menusTopo", menuBe.getListTopo());
			req.setAttribute("menusRodape1", menuBe.getListRodape1());
			req.setAttribute("menusRodape2", menuBe.getListRodape2());

			// Notícias
			
			NoticiaBe noticiaBe = new NoticiaBe(manager);

			Integer totalPaginas = noticiaBe.getQuantidadePaginasNoticias();

			req.setAttribute("noticias", noticiaBe.getPaginaNoticias(pagina));

			Integer paginaAnterior = pagina > 1 ? pagina - 1 : 1;
			Integer proximaPagina = pagina >= totalPaginas ? pagina : pagina + 1;
			Integer ultimaPagina = totalPaginas;

			req.setAttribute("paginaAnterior", paginaAnterior);
			req.setAttribute("proximaPagina", proximaPagina);
			req.setAttribute("ultimaPagina", ultimaPagina);

		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}

		req.getRequestDispatcher("web/pages/site/noticias/noticia_lista.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
