package com.ehrs.restapi.Exception;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ehrs.restapi.Controllers.LogController;
import com.ehrs.restapi.Models.Log;
import com.ehrs.restapi.Repository.LogRepository;
import com.ehrs.restapi.Service.CustomLogService;

public class DatabaseLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseLogger.class);
	static LogRepository logInsert;
	
    public static void logToDatabase(String level, String message) {
        // Call LogService to store the log in the database
		LOGGER.info("Rest API :- " + level + ", Message :- " + message);
		//logInsert.save(new Log(level, message, LocalDateTime.now()));
    }
}
