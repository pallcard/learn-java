package com.wishhust.arithmetic.leetcode;

import com.wishhust.arithmetic.findoffer.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Offer06 {
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        int size = list.size();
        int [] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(size - i - 1);
        }
        return res;
    }
}
