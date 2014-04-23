package br.com.orlandoburli.euvouromper.web.servlets.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.euvouromper.model.be.site.MenuBe;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.ClienteVo;
import br.com.orlandoburli.euvouromper.model.vo.ecommerce.PedidoVo;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.vo.BaseDomain;

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

	public static void buildMenus(HttpServletRequest req, DAOManager manager) throws ListException {
		// Menus

		MenuBe menuBe = new MenuBe(manager);

		req.setAttribute("menusTopo", menuBe.getListTopo());
		req.setAttribute("menusRodape1", menuBe.getListRodape1());
		req.setAttribute("menusRodape2", menuBe.getListRodape2());

		// Carrinho

		if (req.getSession().getAttribute(Constants.Session.CARRINHO) == null) {
			PedidoVo pedido = new PedidoVo();
			ClienteVo cliente = (ClienteVo) req.getSession().getAttribute(Constants.Session.CLIENTE);

			if (cliente != null) {
				pedido.setIdCliente(cliente.getIdCliente());
				pedido.setCliente(cliente);
			}
			req.getSession().setAttribute(Constants.Session.CARRINHO, pedido);
		}
	}

	public static void sendDomain(HttpServletRequest req, BaseDomain domain) {
		Class<?> classe = domain.getClass();

		for (Field f : classe.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers()) && Modifier.isPublic(f.getModifiers())) {
				//
				try {
					String s = (String) f.get(String.class);

					req.setAttribute(f.getName(), s);

				} catch (IllegalArgumentException | IllegalAccessException e) {
					Log.critical(e);
				}
			}
		}
	}
}
