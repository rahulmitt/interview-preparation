package com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank.impl;

import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank.Bank;

public class CitiBank implements Bank {
    private String name;

    public CitiBank() {
        this.name = "Citi Bank";
    }

    @Override
    public String getBankName() {
        return this.name;
    }
}
