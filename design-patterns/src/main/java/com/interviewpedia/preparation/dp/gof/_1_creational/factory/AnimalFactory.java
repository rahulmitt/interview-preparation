package com.interviewpedia.preparation.dp.gof._1_creational.factory;

import com.interviewpedia.preparation.dp.gof._1_creational.factory.impl.Cat;
import com.interviewpedia.preparation.dp.gof._1_creational.factory.impl.Dog;

public class AnimalFactory {
    public enum Type {
        DOG, CAT
    }

    public Animal create(Type type) throws Exception {
        switch (type) {
            case CAT:
                return new Cat();
            case DOG:
                return new Dog();
            default:
                throw new Exception("Invalid type");
        }
    }
}
