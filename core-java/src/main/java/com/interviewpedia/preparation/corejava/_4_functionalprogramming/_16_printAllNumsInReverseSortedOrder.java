package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class _16_printAllNumsInReverseSortedOrder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        functionalStyle(numbers);
    }

    private static void functionalStyle(List<Integer> numbers) {
        numbers.stream().sorted((x, y) -> y.compareTo(x)).forEach(i -> System.out.print(i + ", "));
        // explore the utility methods in Comparator interface
        // numbers.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.print(i + ", "));
    }
}
