package br.com.orlandoburli.euvouromper.web.servlets.geral;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.InstitucionalBe;
import br.com.orlandoburli.euvouromper.model.vo.site.InstitucionalVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Utils;

@WebServlet("/*")
public class TextoInstitucionalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = Utils.getUrl(req);

		if (url == null || url.trim().equals("")) {
			resp.sendRedirect(req.getServletContext().getContextPath() + "/home");

			return;
		}
		
		DAOManager manager = new DAOManager();

		try {

			Log.debug("URL: " + url);

			InstitucionalVo institucional = new InstitucionalBe(manager).getByUrl(url);
			req.setAttribute("institucional", institucional);
		} catch (ListException e) {
			e.printStackTrace();
		} finally {
			manager.commit();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
