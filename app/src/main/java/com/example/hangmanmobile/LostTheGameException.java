package com.example.hangmanmobile;

@SuppressWarnings("serial")
public class LostTheGameException extends Exception {
	
	public LostTheGameException(String message)
	{
		super(message);
	}
}
