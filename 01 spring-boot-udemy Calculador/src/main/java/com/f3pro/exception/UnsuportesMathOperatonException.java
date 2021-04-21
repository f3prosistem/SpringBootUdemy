package com.f3pro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportesMathOperatonException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnsuportesMathOperatonException(String exception) {
		super(exception);
	}
	
	
}
