package br.com.orlandoburli.euvouromper.admin.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class Versao {
	
	private static Versao versao;
	
	String date = "07/04/2014";
	String numeroVersao = "2.1.1";
	
	private Versao() {
		
	}
		
	public static Versao getInstance() {
		if (versao == null) {
			versao = new Versao();
		}
		
		return versao;
	}
	
	public String getNumeroVersao() {
		return numeroVersao;
	}

	public Date getDataVersao() {
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
}
