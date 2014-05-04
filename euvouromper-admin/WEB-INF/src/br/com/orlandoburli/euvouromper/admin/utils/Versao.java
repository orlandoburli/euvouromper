package br.com.orlandoburli.euvouromper.admin.utils;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

public final class Versao {

	private static Versao versao;

	private ServletContext servletContext;

	private Versao() {

	}

	public static Versao getInstance(ServletContext servletContext) {
		if (versao == null) {
			versao = new Versao();
			versao.servletContext = servletContext;
		}
		return versao;
	}

	public String getVersao() {
		Properties prop = new Properties();
		try {
			prop.load(servletContext.getResourceAsStream("/META-INF/MANIFEST.MF"));
			return prop.getProperty("Versao");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "<SEM VERSAO>";
	}

	@Override
	public String toString() {
		return getVersao();
	}
}
