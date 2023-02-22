package com.interviewpedia.preparation.ds;

import java.util.Arrays;
import java.util.Stack;

/*
    https://www.educative.io/edpresso/the-valid-parentheses-problem
*/
public class P7_ValidParentheses {
    public static void main(String[] args) {
        String[] inputs = {
                "{{}}()[()]",
                "{][}",
                "(){",
                "()",
                "(){}[]",
                "(]"
        };
        for (String input : inputs) System.out.println(input + " :: " + isValid(input));

    }

    private static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                default:
                    if (stack.empty()) return false;
                    char top = stack.peek();
                    if (ch == '}' && top == '{' ||
                            ch == ')' && top == '(' ||
                            ch == ']' && top == '[')
                        stack.pop();
                    else return false;
            }
        }
        return stack.isEmpty();
    }
}
