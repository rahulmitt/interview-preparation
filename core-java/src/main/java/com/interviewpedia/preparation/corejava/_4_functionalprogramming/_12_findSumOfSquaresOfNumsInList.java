package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class _12_findSumOfSquaresOfNumsInList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 20, 3, 4, 5, 6, 7, 8, 9, 10);
        structuralStyle(numbers);
        functionalStyle(numbers);
    }

    private static void structuralStyle(List<Integer> numbers) {
        int sum = 0;
        for(int i : numbers) sum += i*i;
        System.out.println("Sum of squares = " + sum);
    }

    private static void functionalStyle(List<Integer> numbers) {
        int sum = numbers.stream().map(i -> i * i).reduce(0, (x, y) -> x + y);
        System.out.println("Sum of squares = " + sum);
    }
}
