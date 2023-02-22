package com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory;

import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank.BankFactory;
import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.loan.LoanFactory;

public interface AbstractFactory {
    enum Type {
        BANK, LOAN
    }

    static AbstractFactory createFactory(Type type) throws Exception {
        switch (type) {
            case BANK:
                return new BankFactory();
            case LOAN:
                return new LoanFactory();
            default:
                throw new Exception("Invalid Factory type");

        }
    }
}
