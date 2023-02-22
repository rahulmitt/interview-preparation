package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class _13_findSumOfOddNumsInList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 20, 3, 4, 5, 6, 7, 8, 9, 10);
        functionalStyle(numbers);
    }

    private static void functionalStyle(List<Integer> numbers) {
        int sum = numbers.stream().filter(i -> i % 2 != 0).reduce(0, (x, y) -> x + y);
        System.out.println("Sum = " + sum);
    }
}
