package com.interviewpedia.preparation.corejava._1_oops;

/*
    Abstract Class vs Interface (java8):
        1. An abstract class is a class and an interface is an interface. A class can have a state which can be modified
        by non-abstract methods but an interface cannot have the state because they can't have instance variables

        2. Abstract class can have constructors but interface cannot have.

        3. Abstract classes lets you define some behaviors and force the subclasses to provide others - template pattern
        Whereas, interfaces are generally used when something in my design is going to change frequently - strategy pattern

    Static methods in Interface:
        Static methods are general utility methods, and are not related to an object's state, it makes sense to define them within the interface.
        These interface static methods are not available to the concrete classes; these can be accessed using the interface name only.
        We can declare public static void main() method inside an interface

    Default methods in Interfaces:
         We can declare concrete methods inside interfaces using Default methods.
         "default" is not an access modifier; it is a keyword used to write concrete methods within interfaces.
         This method is available to the implementation class by default.
         It is up to the implementation class whether to use it as is, or override it.

    More details: https://rahulmitt.github.io/interviewpedia/?course=java&topic=java8&q=7

*/
public class _3_AbstractClassVsInterface {

}
