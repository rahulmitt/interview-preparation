package com.interviewpedia.preparation.dp.gof._1_creational.builder.impl;

import com.interviewpedia.preparation.dp.gof._1_creational.builder.Address;

public class AddressBuilder {
    private String city;
    private String country;

    public static AddressBuilder with() {
        return new AddressBuilder();
    }

    public AddressBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder country(String country) {
        this.country = country;
        return this;
    }

    public Address build() {
        return new ConcreteAddress(city, country);
    }
}
