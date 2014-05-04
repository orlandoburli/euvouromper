package br.com.orlandoburli.euvouromper.model.vo.ecommerce;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class TipoEmail extends BaseDomain {

	public static final String CONFIRMACAO_CADASTRO = "1";
	public static final String PEDIDO_RECEBIDO = "2";
	public static final String PEDIDO_CANCELADO = "3";
	public static final String PEDIDO_LIBERADO = "5";
	public static final String NOVA_SENHA = "6";
	public static final String CONTATO = "7";

	public static final String CONFIRMACAO_CADASTRO_DESCRITIVO = "Confirmação de Cadastro";
	public static final String PEDIDO_RECEBIDO_DESCRITIVO = "Pedido Recebido";
	public static final String PEDIDO_CANCELADO_DESCRITIVO = "Pedido Cancelado";
	public static final String PEDIDO_LIBERADO_DESCRITIVO = "Pedido Liberado";
	public static final String NOVA_SENHA_DESCRITIVO = "Nova Senha";
	public static final String CONTATO_DESCRITIVO = "Contato";

	@Override
	public String[] getValues() {
		return new String[] { CONFIRMACAO_CADASTRO, PEDIDO_RECEBIDO, PEDIDO_CANCELADO, PEDIDO_LIBERADO, NOVA_SENHA, CONTATO };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { CONFIRMACAO_CADASTRO_DESCRITIVO, PEDIDO_RECEBIDO_DESCRITIVO, PEDIDO_CANCELADO_DESCRITIVO, PEDIDO_LIBERADO_DESCRITIVO, NOVA_SENHA_DESCRITIVO, CONTATO_DESCRITIVO };
	}

}
