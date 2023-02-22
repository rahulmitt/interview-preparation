package com.interviewpedia.preparation.dp.gof._3_behavioral.chainofresponsibility.logger;

public class InfoLogger extends Logger {
    public InfoLogger() {
        this.level = LogLevel.INFO;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("INFO: " + msg);
    }
}
