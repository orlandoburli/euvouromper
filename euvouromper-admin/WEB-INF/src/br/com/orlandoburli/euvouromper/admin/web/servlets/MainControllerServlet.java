package br.com.orlandoburli.euvouromper.admin.web.servlets;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.filters.AutorizathionFilter;
import br.com.orlandoburli.framework.core.web.filters.InjectionFilter;

@WebServlet(value = "*.admin", loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String URL = req.getRequestURI();
		URL = URL.substring(URL.lastIndexOf("/") + 1);
		URL = URL.substring(0, URL.lastIndexOf("."));
		
		String facadeName = null;
		String methodName = null;

		facadeName = URL.indexOf(".") >= 0 ? URL.substring(0, URL.indexOf(".")) : URL;
		methodName = URL.indexOf(".") >= 0 ? URL.substring(URL.indexOf(".") + 1) : "execute";

		String className = null;

		try {
			String appdir = req.getServletContext().getRealPath("") + File.separator;
			
			className = Utils.getFacadeName(appdir, facadeName + "Action" + Utils.DOT_CLASS, getServletContext());

			if (className == null) {
				Log.warning("Classe [" + facadeName + "] nao encontrada (null)");
				return;
			}

			Log.debug("className: " + className);

			Class<?> klass = Class.forName(className);
			Object facade = null;

			try {
				Constructor constructor = klass.getConstructor(new Class[] { HttpServletRequest.class, HttpServletResponse.class, ServletContext.class, String.class });
				facade = constructor.newInstance(new Object[] { req, resp, getServletContext(), methodName });
			} catch (NoSuchMethodException ex) { // Se nao tem o construtor com
													// 4 parametros, tenta o
													// padrao
				facade = klass.newInstance();
			}

			if (facade instanceof BaseAction) { // Injeta os atributos request,
												// response e servletcontext
				((BaseAction) facade).setRequest(req);
				((BaseAction) facade).setResponse(resp);
				((BaseAction) facade).setContext(getServletContext());
				((BaseAction) facade).setMethodName(methodName);
			}

			// Seta o nome do metodo no request
			req.setAttribute("methodname", methodName);

			// Execucao dos filtros
			// Filtro para injecao de dependencias
			InjectionFilter ifilter = new InjectionFilter();
			ifilter.setContext(getServletContext());
			ifilter.setRequest(req);
			ifilter.setResponse(resp);

			resp.setCharacterEncoding("UTF-8");

			if (!ifilter.doFilter((BaseAction) facade)) {
				return;
			}

			// Filtro de autorizacao / autenticacao
			AutorizathionFilter afilter = new AutorizathionFilter();
			afilter.setContext(getServletContext());
			afilter.setRequest(req);
			afilter.setResponse(resp);

			if (!afilter.doFilter((BaseAction) facade)) {
				resp.sendRedirect("login.admin");
				return;
			}

			// Invocacao dos metodos
			Log.debug("Invocando metodo " + methodName + " do facade " + facadeName);

			Method method = klass.getMethod(methodName, new Class<?>[] {});
			method.invoke(facade, new Object[] {});

			if (facade instanceof BaseAction) { // Processamento de Outjection
				((BaseAction) facade).dispatch();
			}

		} catch (ClassNotFoundException e) {
			Log.warning("Classe [" + facadeName + "] nao encontrada!");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			Log.warning("Metodo [" + methodName + "] nao existe em [" + className + "]");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}