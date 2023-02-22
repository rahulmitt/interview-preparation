package com.interviewpedia.preparation.dp.gof._1_creational.builder.impl;

import com.interviewpedia.preparation.dp.gof._1_creational.builder.Address;
import com.interviewpedia.preparation.dp.gof._1_creational.builder.Person;

public class ConcretePerson implements Person {
    private String name;
    private int age;
    private Address address;

    ConcretePerson() {
    }

    @Override
    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
