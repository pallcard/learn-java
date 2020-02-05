package com.wishhust.findoffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {

  public boolean IsPopOrder(int [] pushA,int [] popA) {
    Stack<Integer> stack = new Stack();
    int push_index = 0;
    int pop_index = 0;
    while (push_index < pushA.length && pop_index < popA.length) {
      if (pushA[push_index] == popA[pop_index]) {
        push_index++;
        pop_index++;
      } else if(!stack.isEmpty() && stack.peek() == popA[pop_index]) {
        stack.pop();
        pop_index++;
      } else {
        stack.push(pushA[push_index++]);
      }
    }
    while (!stack.isEmpty()) {
      if (stack.pop() != popA[pop_index++]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    boolean b = new IsPopOrder().IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4,5,3,2,1});
    System.out.println(b);
  }
}
