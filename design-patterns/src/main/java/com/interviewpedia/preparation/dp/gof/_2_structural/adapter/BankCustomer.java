package com.interviewpedia.preparation.dp.gof._2_structural.adapter;

// Adapter class
public class BankCustomer extends AccountHolder implements CreditCardHolder {

    @Override
    public String getCreditCard() {
        long accno = getAccountNumber();
        String accholdername = getAccountHolderName();
        String bname = getBankName();

        return ("The Account number " + accno + " of " + accholdername + " in " + bname + "bank is valid and authenticated for issuing the credit card.");
    }
}
