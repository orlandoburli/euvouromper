package br.com.orlandoburli.euvouromper.model.be.admin;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;

public class LoginInvalidoException extends BeException{

	private static final long serialVersionUID = 1L;

	public LoginInvalidoException(String message, String field) {
		super(message, field);
	}

}
