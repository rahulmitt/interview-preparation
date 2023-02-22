package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalProgramming_old {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        printAllNumbersInListFunctional(integerList);
        printEvenNumbersInListFunctional(integerList);
        printOddNumbersInListFunctional(integerList);
        printSquareOfEvenNumbers(integerList);

        int sum = addNumbers(integerList);
        System.out.print("\nsum=" + sum);

        printCubeOfOddNumbers(integerList);
        printSumOfSquareOfNumbers(integerList);
        printSumOfOddNumbers(integerList);

        List<Integer> evenList = createListOfEvenNumbers(integerList);
        System.out.print("\ncreateListOfEvenNumbers ==> " + evenList);

        System.out.println("\n**********************");
        List<String> stringList = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "Openshift", "Azure", "Docker", "Kubernetes");
        printAllCourses(stringList);
        printSpringCourses(stringList);
        printCoursesWithAtleast4Chars(stringList);
        printCharCountInEachCourse(stringList);
        List<Integer> lengthList = createListOfLength(stringList);
        System.out.print("\ncreateListOfLength ==> " + lengthList);


    }

    private static List<Integer> createListOfLength(List<String> stringList) {
        return stringList.stream().map(s -> s.length()).collect(Collectors.toList());
    }

    private static List<Integer> createListOfEvenNumbers(List<Integer> integerList) {
        return integerList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    private static void printSumOfOddNumbers(List<Integer> integerList) {
        int sum = integerList.stream().filter(n -> n % 2 != 0).reduce(0, accumulator);
        System.out.printf("\nprintSumOfOddNumbers ==> " + sum);
    }

    private static BinaryOperator<Integer> accumulator = new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer integer, Integer integer2) {
            return integer + integer2;
        }
    };

    private static void printSumOfSquareOfNumbers(List<Integer> integerList) {
        Function<Integer, Integer> integerIntegerFunction = n -> n * n;

        int sum = integerList.stream().map(integerIntegerFunction).reduce(0, (x, y) -> x + y);
//        int sum = integerList.stream().reduce(0, (x, y) -> x + y * y);
        System.out.print("\nprintSumOfSquareOfNumbers ==>" + sum);
    }

    private static void printCharCountInEachCourse(List<String> stringList) {
        System.out.printf("\nprintCharCountInEachCourse ==> ");
        stringList.stream().map(s -> s + " " + s.length() + " :: ").forEach(System.out::print);
    }

    private static void printCubeOfOddNumbers(List<Integer> integerList) {
        System.out.print("\nprintCubeOfOddNumbers ==> ");
        integerList.stream().map(n -> n * n * n + " ").forEach(System.out::print);
    }

    private static int addNumbers(List<Integer> integerList) {
        return integerList.stream().reduce(0, (a, b) -> a + b);
    }

    private static void printSquareOfEvenNumbers(List<Integer> integerList) {
        System.out.print("\nprintSquareOfEvenNumbers ==> ");
        integerList.stream().filter(n -> n % 2 == 0).map(n -> n * n).map(n -> n + " ").forEach(System.out::print);
    }

    private static void printCoursesWithAtleast4Chars(List<String> stringList) {
        System.out.print("\nprintCoursesWithAtleast4Chars ==> ");
        stringList.stream().filter(s -> s.length() >= 4).map(s -> s + ", ").forEach(System.out::print);
    }

    private static void printSpringCourses(List<String> stringList) {
        System.out.print("\nprintSpringCourses ==> ");
        stringList.stream().filter(s -> s.contains("Spring")).map(s -> s + ", ").forEach(System.out::print);
    }

    private static void printAllCourses(List<String> stringList) {
        System.out.print("\nprintAllCourses ==> ");
        stringList.stream().map(s -> s + ", ").forEach(System.out::print);
    }

    private static void printOddNumbersInListFunctional(List<Integer> list) {
        System.out.print("\nprintEvenNumbersInListFunctional ==> ");
        list.stream().filter( n -> n % 2 != 0).map(n -> n + " ").forEach(System.out::print);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> list) {
        System.out.print("\nprintEvenNumbersInListFunctional ==> ");
        list.stream().filter(n -> n % 2 == 0).map(n -> n + " ").forEach(System.out::print);
    }

    private static void printAllNumbersInListFunctional(List<Integer> list) {
        System.out.print("\nprintAllNumbersInListFunctional ==> ");
        list.stream().map(n -> n + " ").forEach(System.out::print);
    }

}
