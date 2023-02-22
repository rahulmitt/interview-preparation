package com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank;

import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.AbstractFactory;
import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank.impl.CitiBank;
import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank.impl.HDFCBank;

public class BankFactory implements AbstractFactory {

    public Bank createBank(Bank.Type type) throws Exception {
        switch (type) {
            case HDFC:
                return new HDFCBank();
            case CITI:
                return new CitiBank();
            default:
                throw new Exception("Invalid Bank");
        }
    }
}
