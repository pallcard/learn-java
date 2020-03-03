package com.wishhust.arithmetic.findoffer;

/**
 * 删除链表的节点
 *
 * 1. 常规做法： 遍历链表找到删除节点前一个节点
 * 2. o(1)做法： 将下一个结点的值赋值到待删除结点， 然后删除下一个节点
 * 3. 注意对java值传递的理解
 */
public class DeleteNode {

  private void deleteNode(ListNode pListHead, ListNode p) {
    if (p == null) {
      return;
    }
    if (p.next == null) {
      // todo 顺序遍历
      if (pListHead == p) {
        pListHead = null;
        return;
      }
      ListNode pre = pListHead;
      while (pre.next != p) {
        pre = pre.next;
      }
      pre.next = null;
      return;
    }
    ListNode q = p.next;
    p.val = q.val;
    p.next = q.next;
  }

  private ListNode deleteNode2(ListNode pListHead, ListNode p) {
    if (p == null) {
      return pListHead;
    }
    if (p.next == null) {
      // todo 顺序遍历
      if (pListHead == p) {
        return null;
      }
      ListNode pre = pListHead;
      while (pre.next != p) {
        pre = pre.next;
      }
      pre.next = null;
      return pListHead;
    }
    ListNode q = p.next;
    p.val = q.val;
    p.next = q.next;
    return pListHead;
  }

  public static void main(String[] args) {
    ListNode listNode = ListNode.arrayToList(new int[]{1});
    ListNode p = listNode;
    new DeleteNode().deleteNode(listNode, p);
    ListNode.printList(listNode);
    System.out.println("-----------");

    ListNode listNode2 = ListNode.arrayToList(new int[]{1});
    ListNode p2 = listNode2;
    listNode2 = new DeleteNode().deleteNode2(listNode2, p2);
    ListNode.printList(listNode2);
    System.out.println("-----------");

  }
}
