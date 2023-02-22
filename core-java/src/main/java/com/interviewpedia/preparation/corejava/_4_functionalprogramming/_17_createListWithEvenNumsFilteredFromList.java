package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _17_createListWithEvenNumsFilteredFromList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 20, 3, 4, 5, 6, 7, 8, 9, 10);
        functionalStyle(numbers);
    }

    private static void functionalStyle(List<Integer> numbers) {
        List<Integer> evenList = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(evenList);
    }
}
