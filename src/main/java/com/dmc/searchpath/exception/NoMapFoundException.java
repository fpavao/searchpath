/**
 * 
 */
package com.dmc.searchpath.exception;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
public class NoMapFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3698235390300139821L;

	/**
	 * 
	 */
	public NoMapFoundException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NoMapFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoMapFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NoMapFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NoMapFoundException(Throwable cause) {
		super(cause);
	}

	
	
}
