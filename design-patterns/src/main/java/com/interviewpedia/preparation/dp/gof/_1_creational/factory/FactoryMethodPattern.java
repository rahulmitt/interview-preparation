package com.interviewpedia.preparation.dp.gof._1_creational.factory;

public class FactoryMethodPattern {
    public static void main(String[] args) throws Exception {
        AnimalFactory factory = new AnimalFactory();

        Animal aDog = factory.create(AnimalFactory.Type.DOG);
        aDog.walk();
        aDog.eat();

        Animal aCat = factory.create(AnimalFactory.Type.CAT);
        aCat.walk();
        aCat.eat();
    }
}
