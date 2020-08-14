package com.wishhust.arithmetic.leetcode;

import com.wishhust.arithmetic.findoffer.ListNode;

/**
 * 环形链表
 * 快慢指针
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = null;
        if (head != null && head.next != null) {
            q = head.next.next;
        } else {
            return false;
        }
        while (p != null && q != null) {
            if (p == q) {
                return true;
            } else if(q.next != null && p.next != null) {
                p = p.next;
                q = q.next.next;
            } else {
                return false;
            }

        }

        return false;

    }
}
