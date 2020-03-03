package com.wishhust.arithmetic.findoffer;

import java.util.Stack;

public class QueueByStack {
  Stack<Integer> stack1 = new Stack<>();
  Stack<Integer> stack2 = new Stack<>();

  public void push(int node) {
    stack1.push(node);
  }

  public int pop() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        Integer pop = stack1.pop();
        stack2.push(pop);
      }
    }
    return stack2.pop();
  }
}
