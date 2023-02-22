package com.interviewpedia.preparation.dp.gof._3_behavioral.chainofresponsibility.logger;

public class DebugLogger extends Logger {
    public DebugLogger() {
        this.level = LogLevel.DEBUG;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("DEBUG: " + msg);
    }
}
