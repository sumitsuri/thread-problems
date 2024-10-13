package com.solution.lld.logger;

public class ConsoleLoggerFactory implements LoggerFactory{
    @Override
    public Logger getLogger() {
        Logger logger = Logger.getInstance(LogLevel.INFO, new ConsoleLogSink());
        return logger;
    }
}
