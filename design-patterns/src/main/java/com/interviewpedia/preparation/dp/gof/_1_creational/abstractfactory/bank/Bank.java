package com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank;

public interface Bank {
    enum Type {
        HDFC, CITI
    }

    String getBankName();
}
