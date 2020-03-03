package com.wishhust.arithmetic.findoffer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

  public ListNode ReverseList(ListNode head) {
    ListNode p = head, q = head;
    ListNode newHead = null, newTail = null;
    while (p != null) {
      newHead = p;
      p = p.next;
      newHead.next = newTail;
      newTail = newHead;
    }
    return newHead;
  }
}
