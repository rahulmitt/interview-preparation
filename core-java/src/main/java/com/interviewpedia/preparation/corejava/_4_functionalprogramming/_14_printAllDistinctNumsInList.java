package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class _14_printAllDistinctNumsInList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 1);
        functionalStyle(numbers);
    }

    private static void functionalStyle(List<Integer> numbers) {
        numbers.stream().distinct().forEach(i -> System.out.print(i + ", "));
    }
}
