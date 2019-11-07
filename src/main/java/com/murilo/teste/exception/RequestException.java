package com.murilo.teste.exception;

import java.lang.reflect.Constructor;

public class RequestException extends RuntimeException {

	public  RequestException (String messege) {
		super(messege);
	}
	
	public  RequestException (String messege, Throwable cause) {
		super(messege, cause);
	}
	
}
