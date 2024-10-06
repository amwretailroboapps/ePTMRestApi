package com.ehrs.restapi.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.ehrs.restapi.Models.Log;
import com.ehrs.restapi.Service.CustomLogService;

@RestController
@RequestMapping("/api/v1/logs")
public class LogController 
{
	 CustomLogService logService;

    public LogController(CustomLogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public Log logMessage(@RequestParam String level, @RequestParam String message) {
        return logService.saveLog(level, message);
    }
}
