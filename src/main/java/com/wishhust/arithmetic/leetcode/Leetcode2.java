package com.wishhust.arithmetic.leetcode;

import com.wishhust.arithmetic.findoffer.ListNode;

public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;

        ListNode q = l2;

        ListNode head = new ListNode(0);
        ListNode r = head;

        int d = 0;
        while (p != null && q !=null) {
            int sum = p.val + q.val + d;
            d = sum/10;
            r.next = new ListNode(sum % 10);
            r = r.next;
            p = p.next;
            q = q.next;
        }

        while (p!=null) {
            int sum = p.val + d;
            d = sum/10;
            r.next = new ListNode(sum%10);
            r = r.next;
            p = p.next;
        }

        while (q != null) {
            int sum = q.val + d;
            d = sum/10;
            r.next = new ListNode(sum%10);
            r = r.next;
            q = q.next;
        }

        if (d>0) {
            r.next = new ListNode(d);
            r = r.next;
        }
        r.next = null;

        return head.next;
    }

    public static void main(String[] args) {
        ListNode headp = new ListNode(1);
        ListNode p = headp;
        p.next = new ListNode(8);
        p = p.next;
        p.next = null;
        ListNode q = new ListNode(0);
        q.next = null;
        ListNode listNode = new Leetcode2().addTwoNumbers(headp, q);
        System.out.println(listNode);
    }
}
