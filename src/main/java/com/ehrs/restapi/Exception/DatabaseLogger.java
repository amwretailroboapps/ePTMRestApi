package com.ehrs.restapi.Exception;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ehrs.restapi.controllers.LogController;
import com.ehrs.restapi.models.ModelLog;
import com.ehrs.restapi.repository.LogRepository;
import com.ehrs.restapi.services.CustomLogService;

public class DatabaseLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseLogger.class);
	static LogRepository logInsert;
	
    public static void logToDatabase(String level, String message) {
        // Call LogService to store the log in the database
		LOGGER.info("Rest API :- " + level + ", Message :- " + message);
		ModelLog log = new ModelLog();
		log.setLevel(level);
		log.setMessage(message);
		log.setTimestamp(LocalDateTime.now());
		//logInsert.save(log);
		log = null;
    }
}
