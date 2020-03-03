package com.wishhust.arithmetic.findoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * printListFromTailToHead
 */

public class PrintListFromTailToHead {

  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> integerList = new ArrayList<>();
    ListNode r = listNode;
    while (r != null) {
      stack.push(r.val);
      r = r.next;
    }
    while (!stack.isEmpty()) {
      integerList.add(stack.pop());
    }
    return integerList;
  }

}
