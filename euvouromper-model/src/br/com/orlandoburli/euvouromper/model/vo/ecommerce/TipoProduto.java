package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class TipoProduto extends BaseDomain {

	public static final String PACOTE = "P";
	public static final String MODULO = "M";
	public static final String CREDITO = "C";
	public static final String TOTAL = "T";

	public static final String PACOTE_DESCRITIVO = "Pacote";
	public static final String MODULO_DESCRITIVO = "Módulo";
	public static final String CREDITO_DESCRITIVO = "Crédito";
	public static final String TOTAL_DESCRITIVO = "Acesso Total";

	@Override
	public String[] getValues() {
		return new String[] { PACOTE, MODULO, CREDITO, TOTAL };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { PACOTE_DESCRITIVO, MODULO_DESCRITIVO, CREDITO_DESCRITIVO, TOTAL_DESCRITIVO };
	}

}
