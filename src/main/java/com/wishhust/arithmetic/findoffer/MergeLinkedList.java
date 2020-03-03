package com.wishhust.arithmetic.findoffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */

public class MergeLinkedList {
  public ListNode Merge(ListNode list1,ListNode list2) {
    ListNode p = list1;
    ListNode q = list2;
    ListNode newList = null, r = null;
    while (p != null && q != null) {
      if (p.val <= q.val) {
        if (r==null) {
          newList = r = p;
        } else {
          r.next = p;
          r= r.next;
        }
        p = p.next;
      } else {
        if (r==null) {
          newList = r = q;
        } else {
          r.next = q;
          r= r.next;
        }
        q = q.next;
      }
    }
    while (p!=null) {
      if (r==null) {
        newList = r = p;
      } else {
        r.next = p;
        r= r.next;
      }
      p = p.next;
    }
    while (q != null) {
      if (r==null) {
        newList = r = q;
      } else {
        r.next = q;
        r= r.next;
      }
      q = q.next;
    }
    return newList;
  }
}
