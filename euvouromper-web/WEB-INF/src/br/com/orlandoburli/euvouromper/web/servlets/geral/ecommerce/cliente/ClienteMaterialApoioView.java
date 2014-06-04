package br.com.orlandoburli.euvouromper.web.servlets.geral.ecommerce.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.online.MaterialApoioBe;
import br.com.orlandoburli.euvouromper.model.vo.online.MaterialApoioVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet("/materialapoio.page")
public class ClienteMaterialApoioView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		Integer idModulo = null;

		try {
			idModulo = Integer.parseInt(req.getParameter("idModulo"));
		} catch (NumberFormatException | NullPointerException e) {
			idModulo = null;
		}

		if (idModulo != null) {
			DAOManager manager = DAOManager.getDAOManager();
			try {

				MaterialApoioVo filter = new MaterialApoioVo();
				filter.setIdModulo(idModulo);
				req.setAttribute("materiais", new MaterialApoioBe(manager).getList(filter));
			} catch (ListException e) {
				Log.error(e);
			} finally {
				manager.commit();
			}
		}

		req.getRequestDispatcher("/web/pages/ecommerce/cliente/cliente_material_apoio.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
