package com.wishhust.arithmetic.findoffer;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

public class EntryNodeOfLoop {
  public ListNode EntryNodeOfLoop(ListNode pHead) {
    if (pHead == null || pHead.next == null) {
      return null;
    }
    ListNode p = pHead;
    ListNode q = pHead.next.next;
    while (p != null && q != null && p != q) {
      p = p.next;
      if (q.next != null) {
        q = q.next.next;
      } else {
        return null;
      }
    }
    if (p == null || q==null) {
      return null;
    }
    int loopCount = 1;
    p = p.next;
    while (p != null && p != q) {
      p = p.next;
      loopCount++;
    }
    p = pHead;
    q = pHead;
    while (loopCount > 0) {
      q = q.next;
      loopCount--;
    }
    while (p != q) {
      p = p.next;
      q = q.next;
    }
    return p;
  }

  public static void main(String[] args) {
    ListNode listNode = ListNode.arrayToList(new int[]{1, 2, 3, 4, 5});
    ListNode p = listNode;
    p=p.next.next; // 3
    ListNode q = p.next.next;
    q.next = p;
    ListNode listNode1 = new EntryNodeOfLoop().EntryNodeOfLoop(listNode);
    System.out.println(listNode1.val);
  }
}
