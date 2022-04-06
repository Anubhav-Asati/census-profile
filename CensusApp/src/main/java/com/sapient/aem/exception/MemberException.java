package com.sapient.aem.exception;

public class MemberException  extends Exception {
	private static final long serialVersionUID = 1L;


	public MemberException() {
		super("Member Exception");
	}
	
	public MemberException(String message) {
		super(message);
	}
	
	
	public MemberException(String message, Throwable t) {
		super(message,t);
	}

}
