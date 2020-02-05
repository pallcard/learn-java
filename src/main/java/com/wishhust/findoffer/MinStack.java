package com.wishhust.findoffer;

import java.util.Stack;

/**
 * *****
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 */
public class MinStack {

  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> minStack = new Stack<>();

  public void push(int node) {
    if (stack.isEmpty()) {
      minStack.push(node);
    } else {
      Integer peek = minStack.peek();
      if (peek > node) {
        minStack.push(node);
      } else {
        minStack.push(peek);
      }
    }
    stack.push(node);
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int min() {
    return minStack.peek();
  }
}
