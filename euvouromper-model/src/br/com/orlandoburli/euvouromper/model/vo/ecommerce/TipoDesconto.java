package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class TipoDesconto extends BaseDomain {

	public static final String PERCENTUAL = "P";
	public static final String VALOR = "V";

	public static final String PERCENTUAL_DESCRITIVO = "Percentual";
	public static final String VALOR_DESCRITIVO = "Valor";

	@Override
	public String[] getValues() {
		return new String[] { PERCENTUAL, VALOR };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { PERCENTUAL_DESCRITIVO, VALOR_DESCRITIVO };
	}

}
