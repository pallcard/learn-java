package com.wishhust.arithmetic.leetcode;

import java.util.Stack;

public class Leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' ||  ch == '[' || ch == '{') {
                stack.push(ch);
            } else if ((ch == ')' && stack.peek() != '(') || (ch == ']' && stack.peek() != '[') ||(ch == '}' && stack.peek() != '{')) {
                return false;
            } else {
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode20().isValid("[]{}"));
    }
}
