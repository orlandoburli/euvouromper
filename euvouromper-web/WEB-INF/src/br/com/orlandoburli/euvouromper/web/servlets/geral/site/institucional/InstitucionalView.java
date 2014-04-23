package br.com.orlandoburli.euvouromper.web.servlets.geral.site.institucional;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.InstitucionalBe;
import br.com.orlandoburli.euvouromper.model.vo.site.InstitucionalVo;
import br.com.orlandoburli.euvouromper.web.servlets.utils.WebUtils;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/institucional.page")
public class InstitucionalView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOManager manager = DAOManager.getDAOManager();

		try {

			// Menus

			WebUtils.buildMenus(req, manager);

			// Pagina Institucional

			String parametroInstitucional = req.getParameter("institucional");

			InstitucionalVo institucional = new InstitucionalBe(manager).getByUrl(parametroInstitucional);

			req.setAttribute("institucional", institucional);
			
		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}
		
		req.getRequestDispatcher("web/pages/site/institucional/institucional_ver.jsp").forward(req, resp);
	}
}
