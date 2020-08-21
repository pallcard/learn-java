package com.wishhust.arithmetic.leetcode;

import java.util.Stack;

public class Offer09 {

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public Offer09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
