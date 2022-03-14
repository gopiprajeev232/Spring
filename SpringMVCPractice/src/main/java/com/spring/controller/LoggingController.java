package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    Logger log = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/loggingTest")
    public String index() {
        log.trace("Trace msg");
        log.debug("Debug msg");
        log.warn("Warning msg");
        log.error("Error msg");
        log.info("Info msg");

        return "Check logs to see output";
    }
}
