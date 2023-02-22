package com.interviewpedia.preparation.dp.gof._3_behavioral.chainofresponsibility.logger;

public enum LogLevel {
    INFO(1),
    ERROR(2),
    DEBUG(3);

    private final int value;

    LogLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
