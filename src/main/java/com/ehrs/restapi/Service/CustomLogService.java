package com.ehrs.restapi.Service;


import org.springframework.stereotype.Service;

import com.ehrs.restapi.Models.Log;
import com.ehrs.restapi.Repository.LogRepository;

import java.time.LocalDateTime;
@Service
public class CustomLogService {
	LogRepository logRepository;

    public CustomLogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public Log saveLog(String level, String message) {
        Log log = new Log(level, message, LocalDateTime.now());
        return logRepository.save(log);
    }
}
