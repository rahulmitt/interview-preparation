package com.interviewpedia.preparation.dp.gof._1_creational.builder;

import com.interviewpedia.preparation.dp.gof._1_creational.builder.impl.AddressBuilder;
import com.interviewpedia.preparation.dp.gof._1_creational.builder.impl.PersonBuilder;

public class BuilderPattern {
    public static void main(String[] args) {
        Person person = PersonBuilder.with()
                .name("Rahul")
                .age(10)
                .address(
                        AddressBuilder.with()
                                .city("Bangalore")
                                .country("India")
                                .build()
                )
                .build();

        System.out.println(person);
    }
}
