package com.interviewpedia.preparation.dp.gof._3_behavioral.chainofresponsibility.logger;

public abstract class Logger {
    protected LogLevel level;
    protected Logger nextLevelLogger;

    public static Logger getLogger() {
        Logger consoleLogger = new InfoLogger();
        Logger errorLogger = new ErrorLogger();
        Logger debugLogger = new DebugLogger();

        consoleLogger.setNextLevelLogger(errorLogger);
        errorLogger.setNextLevelLogger(debugLogger);
        return consoleLogger;
    }

    public void setNextLevelLogger(Logger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(LogLevel level, String msg) {
        if (this.level.getValue() <= level.getValue()) {
            displayLogInfo(msg);
        }
        if (nextLevelLogger != null) {
            nextLevelLogger.logMessage(level, msg);
        }
    }

    protected abstract void displayLogInfo(String msg);
}
