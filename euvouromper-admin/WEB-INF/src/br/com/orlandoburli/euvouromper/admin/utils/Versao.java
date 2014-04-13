package br.com.orlandoburli.euvouromper.admin.utils;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.servlet.ServletContext;

public final class Versao {
	
	private static Versao versao;
	
	String date = "07/04/2014";
	String numeroVersao = "2.1.1";

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
	
	public String getNumeroVersao() {
		return numeroVersao;
	}

	public Date getDataVersao() {
//		Properties prop = new Properties();
//		prop.load(servletContext.getResourceAsStream("/META-INF/MANIFEST.MF"));
//		return prop.getProperty("Versao");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return new Date(sdf.parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getDataVersaoFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(getDataVersao());
	}
	
	@Override
	public String toString() {
		return getVersao();
	}
}
