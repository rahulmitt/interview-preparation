package com.interviewpedia.preparation.springboot.sort;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BubbleSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] numbers) {
        // logic for bubble sort
        return numbers;
    }
}
