package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _8_createListWithLengthOfCourses {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        functionalStyle(courses);
    }

    private static void functionalStyle(List<String> courses) {
        List<Integer> lengthList = courses.stream().map(c -> c.length()).collect(Collectors.toList());
        System.out.println(lengthList);
    }
}
