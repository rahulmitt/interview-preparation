package com.interviewpedia.preparation.ds;

/**
 * https://leetcode.com/discuss/interview-question/592240/Interesting-String-Question-or-JPMorgan
 */
public class P3_StringWithConsecutiveNumbers {
    public static void main(String[] args) {
        String s1 = "1010";
        System.out.println(s1 + " :: " + countMinSwaps(s1.toCharArray()));

        String s2 = "10100";
        System.out.println(s2 + " :: " + countMinSwaps(s2.toCharArray()));

        String s3 = "10110";
        System.out.println(s3 + " :: " + countMinSwaps(s3.toCharArray()));

        String s4 = "101110";
        System.out.println(s4 + " :: " + countMinSwaps(s4.toCharArray()));

        String s5 = "000010";
        System.out.println(s5 + " :: " + countMinSwaps(s5.toCharArray()));
    }

    private static int countMinSwaps(char[] str) {
        int start = 0;
        int end = str.length - 1;
        while (start < end) {
            if (str[start] == '1') start++;
            else if (str[end] == '0') end--;
            else break;
        }

        int zeros = 0;
        int ones = 0;
        for (int i = start; i <= end; i++) {
            if (str[i] == '0') zeros++;
            if (str[i] == '1') ones++;
        }

        return Math.min(zeros, ones);
    }
}
