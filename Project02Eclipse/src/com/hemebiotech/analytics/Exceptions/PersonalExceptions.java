package com.hemebiotech.analytics.Exceptions;


public class PersonalExceptions extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PersonalExceptions () {
		super();
				
	}
	/**
	 * Send a personal exception
	 * @param message : message of the personal exception
	 */
	public PersonalExceptions (String message) {
		super(message);
		System.out.println(message);		
	}
}