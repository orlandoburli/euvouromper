package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class StatusPedido extends BaseDomain {

	public static final String ABERTO = "A";
	public static final String PAGO = "P";
	public static final String CANCELADO = "C";

	public static final String ABERTO_DESCRITIVO = "Em Aberto";
	public static final String PAGO_DESCRITIVO = "Pago";
	public static final String CANCELADO_DESCRITIVO = "Cancelado";

	@Override
	public String[] getValues() {
		return new String[] { ABERTO, PAGO, CANCELADO };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { ABERTO_DESCRITIVO, PAGO_DESCRITIVO, CANCELADO_DESCRITIVO };
	}

}
