package br.com.orlandoburli.euvouromper.web.servlets.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class WebUtils {

	/**
	 * Redireciona para a home do site.
	 * 
	 * @param req
	 *            Parametro request
	 * @param resp
	 *            Parametro response
	 * @throws IOException
	 */
	public static void goHome(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		goTo(req, resp, "home");
	}

	/**
	 * Redireciona para qualquer url.
	 * 
	 * @param req
	 *            Parametro request
	 * @param resp
	 *            parametro response
	 * @param to
	 *            URL destino
	 * @throws IOException
	 */
	public static void goTo(HttpServletRequest req, HttpServletResponse resp, String to) throws IOException {
		String urlBase = req.getServletContext().getContextPath();

		if (!to.startsWith("/")) {
			to = "/" + to;
		}

		resp.sendRedirect(urlBase + to);
	}
}
