package com.ehrs.restapi.services;


import org.springframework.stereotype.Service;

import com.ehrs.restapi.models.ModelLog;
import com.ehrs.restapi.repository.LogRepository;

import java.time.LocalDateTime;
@Service
public class CustomLogService {
	LogRepository logRepository;

    public CustomLogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public ModelLog saveLog(String level, String message) {
        ModelLog log = new ModelLog(level, message, LocalDateTime.now());
        return logRepository.save(log);
    }
}
