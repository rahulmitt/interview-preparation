package com.interviewpedia.preparation.ds;

import java.util.Arrays;

/**
 * https://leetcode.com/discuss/interview-question/2006832/JPMorgan-Chase-or-Java-Tech-Lead-or-India-or-May-2022-or-HackerRank-or-REJECTED-despite-100-correct
 * <p>
 * Given an array of integers. You take an integer k, and go on adding the elements of the array consecutively.
 * After each addition, the sum must be at least +1. Find least possible value of k satisfying this condition.
 * Example - take this array A = [2, -4, 3, 1]
 * Suppose k = 3
 * 3 + A[0] = 3 + 2 = 5
 * 5 + A[1] = 5 +(-4) = 1
 * 1 + A[2] = 1 + 3 = 4
 * 4 + A[3] = 4 + 1 = 5
 * <p>
 * For k = 3, each sum is at least +1. No value of k smaller than 3 will satisfy this condition.
 * So, answer is k = 3
 * <p>
 * Outline of solution:
 * min = +INFINITY
 * sum = 0
 * <p>
 * for each x in array
 * <p>
 * sum = sum + x
 * min = least of sum and existing min
 * <p>
 * Answer is (1 - min).
 * <p>
 * Time complexity = O(array size)
 * Space complexity = O(1)
 */
public class P5_KIntegerSumArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, -4, 3, 1};
        System.out.println(Arrays.toString(arr) + " :: k=" + solution(arr));
    }

    private static int solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            min = Math.min(min, sum);
        }
        return (1 - min);
    }
}
