package com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank.impl;

import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank.Bank;

public class HDFCBank implements Bank {

    private String name;

    public HDFCBank() {
        this.name = "HDFC Bank";
    }

    @Override
    public String getBankName() {
        return this.name;
    }
}
