package com.wishhust.arithmetic.findoffer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {

  public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    int length1 = 0;
    int length2 = 0;
    ListNode p = pHead1;
    ListNode q = pHead2;
    while (null != p) {
      length1++;
      p = p.next;
    }

    while (null != q) {
      length2++;
      q = q.next;
    }

    int diff = length1 - length2;

    p = pHead1;
    q = pHead2;
    if (diff > 0) {
      for (int i = 0; i < diff; i++) {
        p = p.next;
      }
    } else {
      for (int i = 0; i < -diff; i++) {
        q = q.next;
      }
    }

    while (null != p && null != q && p != q) {
      p = p.next;
      q = q.next;
    }

    return p;
  }
}
