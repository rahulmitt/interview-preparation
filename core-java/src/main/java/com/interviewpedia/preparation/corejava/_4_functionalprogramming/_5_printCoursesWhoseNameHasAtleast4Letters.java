package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.Arrays;
import java.util.List;

public class _5_printCoursesWhoseNameHasAtleast4Letters {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        structuredStyle(courses);

        System.out.println();

        functionalStyle(courses);
    }

    private static void structuredStyle(List<String> courses) {
        for (String course : courses) if (course.length() >= 4) System.out.print(course + ", ");
    }

    private static void functionalStyle(List<String> courses) {
        courses.stream().filter(c -> c.length() >= 4).forEach(course -> System.out.print(course + ", "));
        // Alternatively, below can also be used:
        // courses.stream().filter(c -> c.length() >= 4).map(course -> course + ", ").forEach(System.out::print);
    }
}
