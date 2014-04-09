package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class TipoValidade extends BaseDomain {

	public static final String DIAS = "1";
	public static final String DATA = "2";

	public static final String DIAS_DESCRITIVO = "Dias de acesso";
	public static final String DATA_DESCRITIVO = "Data limite";

	@Override
	public String[] getValues() {
		return new String[] { DIAS, DATA };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] {DIAS_DESCRITIVO, DATA_DESCRITIVO};
	}

}
