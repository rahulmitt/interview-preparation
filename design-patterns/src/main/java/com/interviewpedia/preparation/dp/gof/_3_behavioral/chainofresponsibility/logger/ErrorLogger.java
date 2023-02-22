package com.interviewpedia.preparation.dp.gof._3_behavioral.chainofresponsibility.logger;

public class ErrorLogger extends Logger {
    public ErrorLogger() {
        this.level = LogLevel.ERROR;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("ERROR: " + msg);
    }
}
