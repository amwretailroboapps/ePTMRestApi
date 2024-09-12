package com.epatient.restapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
 class InternalServerError extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InternalServerError(String message) {
		super(message);
	}
}