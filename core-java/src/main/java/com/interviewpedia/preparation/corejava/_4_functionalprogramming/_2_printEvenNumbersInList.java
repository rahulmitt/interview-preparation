package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class _2_printEvenNumbersInList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        structuredStyle(numbers);

        System.out.println();

        functionalStyle(numbers);
    }

    private static void structuredStyle(List<Integer> numbers) {
        for (Integer i : numbers) if (i % 2 == 0) System.out.print(i + ", ");
    }

    private static void functionalStyle(List<Integer> numbers) {
        numbers.stream().filter(i -> i % 2 == 0).forEach(n -> System.out.print(n + ", "));
        // Alternatively, below can also be used:
        // numbers.stream().filter(i -> i % 2 == 0).map(n -> n + ", ").forEach(System.out::print);
    }
}
