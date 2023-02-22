package com.interviewpedia.preparation.dp.gof._1_creational.builder.impl;

import com.interviewpedia.preparation.dp.gof._1_creational.builder.Address;
import com.interviewpedia.preparation.dp.gof._1_creational.builder.Person;

public class PersonBuilder {
    private String name;
    private int age;
    private Address address;

    public static PersonBuilder with() {
        return new PersonBuilder();
    }

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder address(Address address) {
        this.address = address;
        return this;
    }

    public Person build() {
        ConcretePerson person = new ConcretePerson();
        person.setName(name);
        person.setAge(age);
        person.setAddress(address);
        return person;
    }
}
