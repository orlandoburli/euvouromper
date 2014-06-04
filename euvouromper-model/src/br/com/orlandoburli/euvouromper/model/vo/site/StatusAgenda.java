package br.com.orlandoburli.euvouromper.model.vo.site;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class StatusAgenda extends BaseDomain {

	public static final String RASCUNHO = "R";
	public static final String PUBLICADO = "P";
	public static final String INATIVO = "I";

	public static final String RASCUNHO_DESCRITIVO = "Rascunho";
	public static final String PUBLICADO_DESCRITIVO = "Publicado";
	public static final String INATIVO_DESCRITIVO = "Inativo";

	@Override
	public String[] getValues() {
		return new String[] { RASCUNHO, PUBLICADO, INATIVO };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { RASCUNHO_DESCRITIVO, PUBLICADO_DESCRITIVO, INATIVO_DESCRITIVO };
	}

}
