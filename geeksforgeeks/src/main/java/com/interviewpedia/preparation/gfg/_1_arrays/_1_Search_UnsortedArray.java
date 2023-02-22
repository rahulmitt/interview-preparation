package com.interviewpedia.preparation.gfg._1_arrays;


public class _1_Search_UnsortedArray {
    public static void main(String[] args) {
        int[] arr = {20, 5, 7, 25};
        int x = 5;
        int idx = search(arr, x);
    }

    /**
     * Time Complexity: O(n)
     */
    private static int search(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == x) return i;
        return -1;
    }
}
