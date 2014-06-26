package br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;

public class ClienteInexistenteException extends BeException {

	private static final long serialVersionUID = 1L;

	public ClienteInexistenteException(String message, String field) {
		super(message, field);
	}

}
