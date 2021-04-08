package com.returnordermanagement.paymentmodule.exception;

@SuppressWarnings("serial")
public class CardNotFoundException extends Exception {

	public CardNotFoundException(String msg)
	{
		super(msg);
	}
}
