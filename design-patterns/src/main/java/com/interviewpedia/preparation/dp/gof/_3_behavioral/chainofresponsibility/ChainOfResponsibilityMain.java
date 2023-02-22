package com.interviewpedia.preparation.dp.gof._3_behavioral.chainofresponsibility;

import com.interviewpedia.preparation.dp.gof._3_behavioral.chainofresponsibility.logger.LogLevel;
import com.interviewpedia.preparation.dp.gof._3_behavioral.chainofresponsibility.logger.Logger;

public class ChainOfResponsibilityMain {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger();

        logger.logMessage(LogLevel.INFO, "Enter the sequence of values ");
        System.out.println();

        logger.logMessage(LogLevel.ERROR, "An error is occured now");
        System.out.println();

        logger.logMessage(LogLevel.DEBUG, "This was the error now debugging is compeled");
    }
}
