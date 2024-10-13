package com.solution.lld.logger;

public class FileLoggerFactory implements LoggerFactory{
    private String fileName;

    public FileLoggerFactory(String fileName){
        this.fileName = fileName;
    }

    @Override
    public Logger getLogger() {
        return Logger.getInstance(LogLevel.INFO, new FileLogSink(fileName));
    }
}
