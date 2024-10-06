package com.ehrs.restapi.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ehrs.restapi.*;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InternalServerErrorException(String level, String message) {
		super(message);
		DatabaseLogger.logToDatabase(level, message);
	}
}

