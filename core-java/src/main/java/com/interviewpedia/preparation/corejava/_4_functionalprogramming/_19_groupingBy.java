package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class _19_groupingBy {
    public static void main(String[] args) {
        Person p1 = new Person("Rahul Mittal", "Bangalore");
        Person p2 = new Person("Tushar Mittal", "Gurgaon");
        Person p3 = new Person("Neha Bansal", "Bangalore");
        List<Person> personList = Arrays.asList(p1, p2, p3);

        Map<String, Set<Person>> personByCity = personList.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.toSet()));
        System.out.println("personByCity: " + personByCity);

        Map<String, Set<String>> namesByCity = personList.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getName, Collectors.toSet())));
        System.out.println("namesByCity: " + namesByCity);

        Map<String, Set<String>> namesBySortedCity = personList.stream()
                .collect(Collectors.groupingBy(Person::getCity, TreeMap::new, Collectors.mapping(Person::getName, Collectors.toSet())));
        System.out.println("namesBySortedCity: " + namesBySortedCity);
    }

    private static class Person {
        private String name;
        private String city;

        public Person(String name, String city) {
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
}
