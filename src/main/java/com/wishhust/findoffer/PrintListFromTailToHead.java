package com.wishhust.findoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * printListFromTailToHead
 */

class ListNode {
  int val;
  ListNode next = null;

  ListNode(int val) {
    this.val = val;
  }
}

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
