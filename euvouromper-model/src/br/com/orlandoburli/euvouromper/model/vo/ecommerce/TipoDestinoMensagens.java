package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class TipoDestinoMensagens extends BaseDomain {

	public static final String CLIENTE = "C";
	public static final String PRODUTO = "P";
	public static final String TODOS = "T";

	public static final String CLIENTE_DESCRITIVO = "Cliente";
	public static final String PRODUTO_DESCRITIVO = "Produto";
	public static final String TODOS_DESCRITIVO = "Todos";

	@Override
	public String[] getValues() {
		return new String[] { CLIENTE, PRODUTO, TODOS };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { CLIENTE_DESCRITIVO, PRODUTO_DESCRITIVO, TODOS_DESCRITIVO };
	}
}
