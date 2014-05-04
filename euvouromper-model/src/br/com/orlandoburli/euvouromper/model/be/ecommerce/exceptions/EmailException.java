package br.com.orlandoburli.euvouromper.model.be.ecommerce.exceptions;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;

public class EmailException extends BeException {

	private static final long serialVersionUID = 1L;

	public EmailException(String message) {
		super(message);
	}

}
