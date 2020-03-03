package com.wishhust.arithmetic.findoffer;

class RandomListNode {

  int label;
  RandomListNode next = null;
  RandomListNode random = null;

  RandomListNode(int label) {
    this.label = label;
  }
}

public class RandomListNodeClone {

  public RandomListNode Clone(RandomListNode pHead) {
    if (null == pHead) {
      return null;
    }
    RandomListNode p = pHead;
    RandomListNode q;
    // copy list  a-b-c   => a-a1-b-b1-c-c1
    while (null != p) {
      q = p.next;
      RandomListNode p1 = new RandomListNode(p.label);
      p.next = p1;
      p1.next = q;
      p = q;
    }
    // add random pointer
    p = pHead;
    while (null != p) {
      q = p.next;
      if (null == p.random) {
        q.random = null;
      } else {
        q.random = p.random.next;
      }
      p = p.next.next;
    }
    // split list
    RandomListNode rHead = pHead.next;
    RandomListNode rTail = rHead;
    p = pHead;
    while (null != p) {
      p.next = rTail.next;
      p = p.next;
      if (p == null) {
        rTail.next = null;
      } else {
        rTail.next = p.next;
        rTail = rTail.next;
      }
    }
    return rHead;
  }
}
