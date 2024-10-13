package com.solution.lld.logger;

import java.util.Date;

public class Logger {
    private static Logger logger;
    private LogLevel logLevel;
    private LogSink logSink;

    private Logger(){
        this.logLevel = LogLevel.INFO;
        this.logSink = new ConsoleLogSink();
    }

    private Logger(LogLevel logLevel, LogSink logSink){
        this.logLevel = logLevel;
        this.logSink = logSink;
    }

    public static Logger getInstance(){
        if(logger == null){
            logger = new Logger();
        }
        return logger;
    }

    public static Logger getInstance(LogLevel logLevel, LogSink logSink){
        if(logger == null){
            logger = new Logger(logLevel, logSink);
        }
        return logger;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void setLogSink(LogSink logSink) {
        this.logSink = logSink;
    }

    public void log(LogLevel logLevel, String message){
        if(logLevel.ordinal() >= this.logLevel.ordinal()){
            String logMessage = "[" + new Date() + "]" + "[" + logLevel + "] " + message;
            logSink.logMessage(logMessage);
        }
    }
}
