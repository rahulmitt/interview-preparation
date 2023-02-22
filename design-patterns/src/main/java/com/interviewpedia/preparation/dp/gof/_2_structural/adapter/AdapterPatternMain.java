package com.interviewpedia.preparation.dp.gof._2_structural.adapter;

/**
 * Converts the interface of a class into another interface that a client wants
 *
 * Advantages:
 *     It allows two or more previously incompatible objects to interact.
 *     It allows reusability of existing functionality.
 *
 * Usage of Adapter pattern:
 *  It is used:
 *     When an object needs to utilize an existing class with an incompatible interface.
 *     When you want to create a reusable class that cooperates with classes which don't have compatible interfaces.
 *
 * CreditCardHolder.java — target interface
 * AccountHolder.java — Adaptee class
 * BankCustomer.java — Adapter class
 */
public class AdapterPatternMain {
    public static void main(String[] args) {
        CreditCardHolder targetInterface = new BankCustomer();
        System.out.println(targetInterface.getCreditCard());
    }
}
