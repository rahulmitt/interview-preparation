package com.interviewpedia.preparation.corejava._1_oops;

/*
    RULES:
        1. Don't allow subclasses — declare the class as final
        2. Make all the fields as final and private
        3. Don't provide setter methods — methods that modify fields or objects referred by fields
        4. All parameterized constructors must make a defensive copy of parameters before settings the object's state.
        5. All getter methods must return a defensive copy.
*/
public class _5_ImmutableClass {

    public static void main(String[] args) {
        Address address = new Address("Bangalore", "India");
        Person person = new Person("Rahul", 30, address);
        System.out.println(person);

        address.setCity("Mumbai");
        System.out.println(person);

        person.getAddress().setCountry("Glasgow");
        System.out.println(person);
    }

    final private static class Person {
        private final String name;
        private final int age;
        private final Address address;    // Mutable

        public Person(String name, int age, Address address) {
            this.name = name;
            this.age = age;
            this.address = new Address(address.getCity(), address.getCountry());
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Address getAddress() {
            return new Address(address.getCity(), address.getCountry());
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

    private final static class Address {
        private String city;
        private String country;

        public Address(String city, String country) {
            this.city = city;
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }
}
