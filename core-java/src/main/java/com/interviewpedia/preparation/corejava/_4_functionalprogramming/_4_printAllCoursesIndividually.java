package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class _4_printAllCoursesIndividually {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        structuredStyle(courses);

        System.out.println();

        functionalStyle(courses);
    }

    private static void structuredStyle(List<String> courses) {
        for (String course : courses) System.out.print(course + ", ");
    }

    private static void functionalStyle(List<String> courses) {
        courses.forEach(course -> System.out.print(course + ", "));
        // Alternatively, below can also be used:
        // courses.stream().map(course -> course + ", ").forEach(System.out::print);
    }
}
