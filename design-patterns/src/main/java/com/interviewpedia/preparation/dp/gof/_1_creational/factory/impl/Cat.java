package com.interviewpedia.preparation.dp.gof._1_creational.factory.impl;

import com.interviewpedia.preparation.dp.gof._1_creational.factory.Animal;

public class Cat extends Animal {
    @Override
    public void walk() {
        System.out.println("Cat walks");
    }

    @Override
    public void eat() {
        System.out.println("Cat eats");
    }
}
