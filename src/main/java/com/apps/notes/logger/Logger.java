package com.apps.notes.logger;

import java.util.logging.Level;

public class Logger{

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    private static final String ERROR = "ERROR";

    public static void info(String message) {
        logger.log(Level.INFO,message);
    };

    public static void error(String message) {
        logger.log(Level.parse(ERROR),message);
    };
}
