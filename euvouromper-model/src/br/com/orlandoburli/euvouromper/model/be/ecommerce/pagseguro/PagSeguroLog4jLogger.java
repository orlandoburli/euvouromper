package br.com.orlandoburli.euvouromper.model.be.ecommerce.pagseguro;

import br.com.orlandoburli.framework.core.log.Log;
import br.com.uol.pagseguro.logs.Logger;

public class PagSeguroLog4jLogger implements Logger {

	public PagSeguroLog4jLogger(Class<?> clazz) {
	}

	public void info(String message) {
		Log.info(message);
	}

	public void debug(String message) {
		Log.debug(message);

	}

	public void warn(String message) {
		Log.warning(message);

	}

	public void error(String message) {
		Log.error(message);
	}

	public void warn(String message, Throwable t) {
		Log.warning(message + t);

	}

	public void error(String message, Throwable t) {
		Log.error(message + t);
	}
}