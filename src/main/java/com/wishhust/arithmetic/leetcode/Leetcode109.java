package com.wishhust.arithmetic.leetcode;

import com.wishhust.arithmetic.findoffer.ListNode;

public class Leetcode109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = findMid(head);
        TreeNode root = null;
        if (pre != null) {
            ListNode mid = pre.next;
            pre.next = null;
            if (mid != null) {
                root = new TreeNode(mid.val);
                root.left = sortedListToBST(head);
                root.right = sortedListToBST(mid.next);
            } else {
                return new TreeNode(pre.val);
            }
        }
        return root;
    }


    // 找到中间值的前面一个
    public ListNode findMid(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q.next !=null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }
}
