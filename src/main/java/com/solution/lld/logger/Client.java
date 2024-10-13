package com.solution.lld.logger;

public class Client {
  public static void main(String[] args) {
    //
  Logger logger = Logger.getInstance();
  logger.setLogSink(new ConsoleLogSink());
  logger.setLogLevel(LogLevel.INFO);

  logger.log(LogLevel.INFO, "This is info message");
  logger.log(LogLevel.WARN, "This is warn message");
    logger.log(LogLevel.ERROR, "This is error message");
  }
}
