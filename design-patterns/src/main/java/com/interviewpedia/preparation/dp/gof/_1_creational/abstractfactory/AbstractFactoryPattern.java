package com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory;

import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank.Bank;
import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.bank.BankFactory;
import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.loan.Loan;
import com.interviewpedia.preparation.dp.gof._1_creational.abstractfactory.loan.LoanFactory;

public class AbstractFactoryPattern {
    public static void main(String[] args) throws Exception {
        BankFactory bankFactory = (BankFactory) AbstractFactory.createFactory(AbstractFactory.Type.BANK);
        LoanFactory loanFactory = (LoanFactory) AbstractFactory.createFactory(AbstractFactory.Type.LOAN);

        Bank hdfc = bankFactory.createBank(Bank.Type.HDFC);
        System.out.println(hdfc.getBankName());

        Bank citi = bankFactory.createBank(Bank.Type.CITI);
        System.out.println(citi.getBankName());

        Loan personal = loanFactory.createLoan(Loan.Type.PERSONAL);
        System.out.println(personal.getInterestRate());

        Loan home = loanFactory.createLoan(Loan.Type.HOME);
        System.out.println(home.getInterestRate());
    }
}
