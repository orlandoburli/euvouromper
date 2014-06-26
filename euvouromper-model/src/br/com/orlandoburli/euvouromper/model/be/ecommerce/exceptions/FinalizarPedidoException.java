package br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;

public class FinalizarPedidoException extends BeException {

	private static final long serialVersionUID = 1L;

	public FinalizarPedidoException(String message) {
		super(message, null);
	}

	public FinalizarPedidoException(String message, String field) {
		super(message, field);
	}

}
