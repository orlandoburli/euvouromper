package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class TipoProduto extends BaseDomain {

	public static final String PACOTE = "P";
	public static final String MODULO = "M";
	public static final String CREDITO = "C";
	public static final String TOTAL = "T";
	public static final String VIDEO_INDIVIDUAL = "V";

	public static final String PACOTE_DESCRITIVO = "Pacote";
	public static final String MODULO_DESCRITIVO = "Módulo";
	public static final String CREDITO_DESCRITIVO = "Crédito";
	public static final String TOTAL_DESCRITIVO = "Acesso Total";
	public static final String VIDEO_INDIVIDUAL_DESCRITIVO = "Vídeo Individual";

	@Override
	public String[] getValues() {
		return new String[] { PACOTE, MODULO, CREDITO, TOTAL, VIDEO_INDIVIDUAL };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { PACOTE_DESCRITIVO, MODULO_DESCRITIVO, CREDITO_DESCRITIVO, TOTAL_DESCRITIVO, VIDEO_INDIVIDUAL_DESCRITIVO };
	}

}
