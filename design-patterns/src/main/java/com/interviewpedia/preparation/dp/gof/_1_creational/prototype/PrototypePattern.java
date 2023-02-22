package com.interviewpedia.preparation.dp.gof._1_creational.prototype;

public class PrototypePattern {
    public static void main(String[] args) {
        Prototype person = new Person("Rahul", 10, 100.0);
        System.out.println(person + " :: hashcode: " + person.hashCode());

        Prototype prototype = person.createPrototype();
        System.out.println(prototype + " :: hashcode: " + prototype.hashCode());
    }
}
