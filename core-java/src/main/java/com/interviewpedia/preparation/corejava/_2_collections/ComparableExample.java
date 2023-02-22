package com.interviewpedia.preparation.corejava._2_collections;

import java.util.*;

public class ComparableExample {
    public static void main(String[] args) {
        Country india = new Country("India", 500);
        Country pak = new Country("Pakistan", 100);
        Country sri = new Country("Srilanka", 50);

        Map<Country, Integer> countryPopulationMap = new HashMap<>();
        countryPopulationMap.put(india, 5000);
        countryPopulationMap.put(pak, 20000);
        countryPopulationMap.put(sri, 500);

        Map<Country, Integer> nameSorted = new TreeMap<>(countryPopulationMap);
        System.out.println("Sort by Name: " + nameSorted);

//        Map<Country, Integer> populationSorted = new TreeMap<>(new AreaComparator());
//        populationSorted.putAll(countryPopulationMap);
//        System.out.println("Sort by population: " + populationSorted);

        Map<Country, Integer> populationSorted = new TreeMap<>(new Comparator<Country>() {
            public int compare(Country c1, Country c2) {
                return c1.getArea().compareTo(c2.getArea());
            }
        });
        populationSorted.putAll(countryPopulationMap);
        System.out.println("Sort by population: " + populationSorted);

        Map<Country, Integer> areaSorted = new TreeMap<>(new Comparator<Country>() {
            public int compare(Country c1, Country c2) {
                return c1.getArea().compareTo(c2.getArea());
            }
        });
        areaSorted.putAll(countryPopulationMap);
        System.out.println("Sort by Area: " + areaSorted);

    }


    private static class Country implements Comparable<Country> {
        private String name;

        private Integer area;

        public Country(String name, Integer area) {
            this.name = name;
            this.area = area;
        }

        public String getName() {
            return name;
        }

        public Integer getArea() {
            return area;
        }

        @Override
        public int compareTo(Country o) {
            return name.compareTo(o.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Country country = (Country) o;
            return name.equals(country.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Country{" +
                    "name='" + name + '\'' +
                    ", area=" + area +
                    '}';
        }
    }

    private static class AreaComparator implements Comparator<Country> {
        @Override
        public int compare(Country country1, Country country2) {
            return country1.getArea().compareTo(country2.getArea());
        }
    }
}
