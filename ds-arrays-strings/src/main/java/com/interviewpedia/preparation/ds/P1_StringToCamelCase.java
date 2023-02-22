package com.interviewpedia.preparation.ds;

/**
 * https://leetcode.com/discuss/interview-question/1535264/jp-morgan-hirevue-oa-camel-case-machine-decode-numbers-from-jumbled-english
 * https://www.baeldung.com/java-string-to-camel-case
*/
public class P1_StringToCamelCase {
    public static void main(String[] args) {
        String input = "this is a    _   SAMPLE string";
        StringBuilder output = new StringBuilder();
        String[] words = input.split("[\\W_]+");

        System.out.println("INPUT: " + input);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == 0) {
                word = word.toLowerCase();
            } else {
                word = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            }
            output.append(word);
        }
        System.out.println("OUTPUT: " + output);
    }
}
