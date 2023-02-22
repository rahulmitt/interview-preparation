package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class _15_printAllNumsInSortedOrder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        functionalStyle(numbers);
    }

    private static void functionalStyle(List<Integer> numbers) {
        numbers.stream().sorted().forEach(i -> System.out.print(i + ", "));
    }
}
