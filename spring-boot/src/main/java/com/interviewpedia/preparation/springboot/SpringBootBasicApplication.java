package com.interviewpedia.preparation.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootBasicApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringBootBasicApplication.class);

        BinarySearch binarySearch = applicationContext.getBean(BinarySearch.class);
        int result = binarySearch.search(new int[]{12, 4, 6}, 3);
        System.out.println(result);
    }
}
