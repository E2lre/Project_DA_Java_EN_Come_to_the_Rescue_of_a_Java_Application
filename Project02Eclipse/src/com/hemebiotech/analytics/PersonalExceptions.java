package com.hemebiotech.analytics;


public class PersonalExceptions extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PersonalExceptions () {
		super();
				
	}
	public PersonalExceptions (String message) {
		super(message);
		System.out.println(message);		
	}
}