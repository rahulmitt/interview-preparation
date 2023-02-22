package com.interviewpedia.preparation.dp.gof._1_creational.factory.impl;

import com.interviewpedia.preparation.dp.gof._1_creational.factory.Animal;

public class Dog extends Animal {
    @Override
    public void walk() {
        System.out.println("Dog walks");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats");
    }
}
