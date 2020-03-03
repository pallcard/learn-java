package com.wishhust.arithmetic.findoffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class FindKthToTail {
  public ListNode FindKthToTail(ListNode head,int k) {
    ListNode p = head;
    int count = 0;
    while (p != null) {
      p = p.next;
      count++;
    }
    if (k > count) {
      return null;
    }
    p = head;
    for (int i = 0; i < count - k; i++) {
      p = p.next;
    }
    return p;
  }
}
