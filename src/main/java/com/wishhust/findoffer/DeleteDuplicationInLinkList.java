package com.wishhust.findoffer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationInLinkList {
  public ListNode deleteDuplication(ListNode pHead) {
    ListNode p = pHead;
    ListNode pre = null;
    while (p != null && p.next != null) {
      ListNode q = p.next;
      if (p.val == q.val) {
        while (q.next != null && p.val == q.next.val) {
          q = q.next;
        }
        if (pre == null) {
          pHead = q.next;
          p = pHead;
        } else {
          pre.next = p.next.next;
          p = pre.next;
        }
      } else {
        pre = p;
        p = p.next;
      }
    }
    return pHead;
  }
}
