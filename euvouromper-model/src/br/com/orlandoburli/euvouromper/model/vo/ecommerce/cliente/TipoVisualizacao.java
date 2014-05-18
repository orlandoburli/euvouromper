package br.com.orlandoburli.euvouromper.model.vo.ecommerce.cliente;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class TipoVisualizacao extends BaseDomain {

	public static final String GRATUITA = "G";
	public static final String TOTAL = "T";
	public static final String PACOTE = "P";
	public static final String MODULO = "M";
	public static final String INDIVIDUAL = "I";

	public static final String GRATUITA_DESCRITIVO = "Gratuito";
	public static final String TOTAL_DESCRITIVO = "Total";
	public static final String PACOTE_DESCRITIVO = "Pacote";
	public static final String MODULO_DESCRITIVO = "Módulo";
	public static final String INDIVIDUAL_DESCRITIVO = "Individual";

	@Override
	public String[] getValues() {
		return new String[] { GRATUITA, TOTAL, PACOTE, MODULO, INDIVIDUAL };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { GRATUITA_DESCRITIVO, TOTAL_DESCRITIVO, PACOTE_DESCRITIVO, MODULO_DESCRITIVO, INDIVIDUAL_DESCRITIVO };
	}

}
