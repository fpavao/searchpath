/**
 * 
 */
package com.dmc.searchpath.exception;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
public class NoRouteFoundException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7423863043079969248L;

	/**
	 * 
	 */
	public NoRouteFoundException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NoRouteFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoRouteFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NoRouteFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NoRouteFoundException(Throwable cause) {
		super(cause);
	}

	
	
}
