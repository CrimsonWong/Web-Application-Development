package com.me.exception;

public class MessageException extends Exception {

	public MessageException(String message)
	{
		super("messageException-"+message);
	}
	
	public MessageException(String message, Throwable cause)
	{
		super("messageException-"+message,cause);
	}
	
}