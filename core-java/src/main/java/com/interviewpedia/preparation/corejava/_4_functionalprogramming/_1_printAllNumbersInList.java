package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class _1_printAllNumbersInList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        structuredStyle(numbers);

        System.out.println();

        functionalStyle(numbers);
    }

    private static void structuredStyle(List<Integer> numbers) {
        for (Integer i : numbers) System.out.print(i + ", ");
    }

    private static void functionalStyle(List<Integer> numbers) {
        numbers.forEach(n -> System.out.print(n + ", "));
        // Alternatively, below can also be used:
        // numbers.stream().map(n -> n + ", ").forEach(System.out::print);
    }
}
