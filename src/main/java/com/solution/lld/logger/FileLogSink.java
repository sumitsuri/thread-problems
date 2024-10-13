package com.solution.lld.logger;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FileLogSink implements LogSink{

    private String fileName;

    public FileLogSink(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logMessage(String message) {
        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName, true))){
            pw.println(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
