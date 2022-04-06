package com.sapient.aem.exception;

public class CensusProfileException extends Exception {
	
	private static final long serialVersionUID = 1L;


	public CensusProfileException() {
		super("CensusProfile Exception");
	}
	
	public CensusProfileException(String message) {
		super(message);
	}
	
	
	public CensusProfileException(String message, Throwable t) {
		super(message,t);
	}

}
