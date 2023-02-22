package com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.loan;

import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.AbstractFactory;
import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.loan.impl.HomeLoan;
import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.loan.impl.PersonalLoan;

public class LoanFactory implements AbstractFactory {

    public Loan createLoan(Loan.Type type) throws Exception {
        switch (type) {
            case HOME:
                return new HomeLoan();
            case PERSONAL:
                return new PersonalLoan();
            default:
                throw new Exception("Invalid Loan type");
        }
    }
}
