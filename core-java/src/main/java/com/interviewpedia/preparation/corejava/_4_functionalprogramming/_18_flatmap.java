package com.interviewpedia.preparation.corejava._4_functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _18_flatmap {
    public static void main(String[] args) {
        Course english = new Course("English");
        Course hindi = new Course("Hindi");
        Course maths = new Course("Maths");
        Course science = new Course("Science");
        Course java = new Course("Java");
        Course python = new Course("Python");

        Student rahul = new Student("Rahul");
        rahul.addCourses(english, hindi, java);

        Student tushar = new Student("Tushar");
        tushar.addCourses(english, hindi, java, maths, science, python);

        List<Student> students = Arrays.asList(rahul, tushar);

        System.out.print("Prints all courses by all students: ");
        students.stream().flatMap(student -> student.getCourses().stream()).forEach(c -> System.out.print(c.getName() + ", "));
        System.out.println();

        System.out.print("Prints unique courses by all students: ");
        students.stream().flatMap(student -> student.getCourses().stream()).collect(Collectors.toSet()).forEach(c -> System.out.print(c.getName() + ", "));
    }

    private static class Student {
        private final String name;
        private final List<Course> courses = new ArrayList<>();

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Course> getCourses() {
            return courses;
        }

        public void addCourse(Course course) {
            courses.add(course);
        }

        public void addCourses(Course... courses) {
            this.courses.addAll(Arrays.asList(courses));
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", courses=" + courses +
                    '}';
        }
    }

    private static class Course {
        private String name;

        public Course(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
