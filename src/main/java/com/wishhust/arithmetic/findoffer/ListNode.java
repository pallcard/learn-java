package com.wishhust.arithmetic.findoffer;


public class ListNode {
  public int val;
  public ListNode next = null;

  public ListNode(int val) {
    this.val = val;
  }

  public static ListNode arrayToList(int [] array) {
    ListNode head = new ListNode(0);
    ListNode tail = head;
    for (int i = 0; i < array.length; i++) {
      ListNode node = new ListNode(array[i]);
      tail.next = node;
      tail = node;
    }
    tail.next = null;
    return head.next;
  }

  public static void printList(ListNode head) {
    ListNode p = head;
    while (p != null) {
      System.out.print(p.val + " ");
      p = p.next;
    }
  }
}
