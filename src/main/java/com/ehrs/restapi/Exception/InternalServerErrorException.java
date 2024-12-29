package com.ehrs.restapi.Exception;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ehrs.restapi.*;
import com.ehrs.restapi.models.ModelLog;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InternalServerErrorException(String level, String message) {
		super(message);
		ModelLog log = new ModelLog();
		log.setLevel(level);
		log.setMessage(message);
		log.setTimestamp(LocalDateTime.now());
		//DatabaseLogger.logToDatabase(level, message);
		DatabaseLogger.logToDatabase(level, message);
	}
}

