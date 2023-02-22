package com.interviewpedia.preparation.gfg._1_arrays;

public class _3_Insert {
    public static void main(String[] args) {

    }

    /**
     * Time Complexity: O(n)
     */
    private static int insert(int[] arr, int size, int capacity, int data, int pos) {
        if (size == capacity) return size;

        int idx = pos - 1;
        for (int i = size - 1; i > idx; i--) arr[i + 1] = arr[i];
        arr[idx] = data;
        return size + 1;
    }
}
