package com.ciandt.entregas.exceptions;

public class BusinessException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(final Throwable throwable) {
		super(throwable);
	}
	
	public BusinessException(final String mensagem, final Throwable throwable) {
		super(mensagem, throwable);
	}
	
	public BusinessException(final String mensagem) {
		super(mensagem);
	}
}
