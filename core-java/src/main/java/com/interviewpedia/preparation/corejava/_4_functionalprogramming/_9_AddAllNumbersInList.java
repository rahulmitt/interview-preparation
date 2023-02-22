package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class _9_AddAllNumbersInList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        structuredStyle(numbers);

        System.out.println();

        functionalStyle(numbers);
    }

    private static void structuredStyle(List<Integer> numbers) {
        int sum = 0;
        for (Integer i : numbers) sum += i;
        System.out.println("Sum=" + sum);
    }

    private static void functionalStyle(List<Integer> numbers) {
        int sum = numbers.stream().reduce(0, (aggregate, i) -> aggregate + i);
        System.out.println("Sum=" + sum);
    }
}
