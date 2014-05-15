package br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class TipoMovimentacao extends BaseDomain {

	public static final String CREDITO = "C";
	public static final String DEBITO = "D";

	public static final String CREDITO_DESCRITIVO = "Crédito";
	public static final String DEBITO_DESCRITIVO = "Débito";

	@Override
	public String[] getValues() {
		return new String[] { CREDITO, DEBITO };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { CREDITO_DESCRITIVO, DEBITO_DESCRITIVO };
	}

}
