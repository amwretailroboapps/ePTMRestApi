package com.ehrs.restapi.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.ehrs.restapi.models.ModelLog;
import com.ehrs.restapi.services.CustomLogService;

@RestController
@RequestMapping("/ehrs_almeezan/api/v1/logs")
public class LogController 
{
	 CustomLogService logService;

    public LogController(CustomLogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ModelLog logMessage(@RequestParam String level, @RequestParam String message) {
        return logService.saveLog(level, message);
    }
}
