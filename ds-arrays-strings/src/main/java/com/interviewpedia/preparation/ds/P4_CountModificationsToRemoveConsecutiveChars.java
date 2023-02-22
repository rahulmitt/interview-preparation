package com.interviewpedia.preparation.ds;

import java.util.Arrays;

/**
 * https://leetcode.com/discuss/interview-question/2006832/JPMorgan-Chase-or-Java-Tech-Lead-or-India-or-May-2022-or-HackerRank-or-REJECTED-despite-100-correct
 * <p>
 * Given an array of strings. For each string, return the least number of characters to be modified so that there are
 * NO consecutive identical characters in any string. All strings are non-empty and contain only lowercase English letters a-z.
 * <p>
 * Example : ab - 0 changes needed as there are no two identical consecutive characters in this string
 * aaa - change the middle a to something else - so just 1 modification needed
 * aaaab - change either first and third 'a' to something else, or else change 2nd and 4th 'a' to something else - 2 modifications needed
 * aaacc - change middle 'a' to something else and change one of the 'c' to something else - so just 2 modifications needed
 * aaaaabbbcc - change 2nd and 4th 'a', change middle 'b' and change any one of the 'c' - total 4 modifications needed
 * <p>
 * So, for input as [ab, aaa, aaab, aaacc, aaaaabbbcc], expected output is [0, 1, 1, 2, 4]
 * <p>
 * Outline of solution : For each string, check how many chains are there. A chain is a sequence of at least 2 identical consecutive characters.
 * <p>
 * For the string aaaaabbbcc, there are these chains - aaaaa, bbb and cc
 * Number of replacements = sum of (chainLength / 2) [integer division]
 * <p>
 * For abcd, there are 4 chains - a, b, c, d - each of length 1
 * Easily passed all tests
 * <p>
 * Time complexity = O(sum of all string lengths)
 * Space complexity = O(number of strings)
 */
public class P4_CountModificationsToRemoveConsecutiveChars {
    public static void main(String[] args) {
        String s1 = "aaa";
        System.out.println(s1 + " :: " + countReplacements(s1.toCharArray()));

        String s2 = "aaaab";
        System.out.println(s2 + " :: " + countReplacements(s2.toCharArray()));

        String s3 = "aaacc";
        System.out.println(s3 + " :: " + countReplacements(s3.toCharArray()));

        String s4 = "aaaaabbbcc";
        System.out.println(s4 + " :: " + countReplacements(s4.toCharArray()));

        String[] strings = new String[]{"ab", "aaa", "aaab", "aaacc", "aaaaabbbcc"};
        int[] output = new int[strings.length];
        for (int i = 0; i < strings.length; i++) output[i] = countReplacements(strings[i].toCharArray());
        System.out.println(Arrays.toString(strings) + " :: " + Arrays.toString(output));
    }

    private static int countReplacements(char[] str) {
        if (str.length <= 1) return 0;

        int replacements = 0;
        int start = 0;
        while (start < str.length) {
            int end = start + 1;
            for (; end < str.length && str[start] == str[end]; end++) ;
            replacements += (end - start) / 2;
            start = end;
        }
        return replacements;
    }
}
