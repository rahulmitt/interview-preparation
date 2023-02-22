package com.interviewpedia.preparation.dp.gof._1_creational.builder.impl;

import com.interviewpedia.preparation.dp.gof._1_creational.builder.Address;

public class ConcreteAddress implements Address {
    private String city;
    private String country;

    ConcreteAddress(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
