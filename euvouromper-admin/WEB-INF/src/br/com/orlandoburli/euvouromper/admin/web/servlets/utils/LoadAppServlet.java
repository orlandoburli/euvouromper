package br.com.orlandoburli.euvouromper.admin.web.servlets.utils;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.orlandoburli.euvouromper.model.utils.DBUtils;
import br.com.orlandoburli.framework.core.log.Log;

@WebServlet(value = "/load", loadOnStartup = 1)
public class LoadAppServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();

		try {
			System.getProperties().load(getServletContext().getResourceAsStream("admin.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		Log.info("Inicializando app Admin - Site Eu Vou Romper");

		Log.info("Propriedades carregadas.");

		DBUtils.checkDaos();

		Log.info("DAOs checadas.");

		Locale.setDefault(new Locale("pt", "BR"));

		Log.info("App admin inicializado.");
	}
}
