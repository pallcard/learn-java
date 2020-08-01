package com.wishhust.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        int [] result = new int[nums.length-k+1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                // 单调队列
                while (!deque.isEmpty() && nums[i]>deque.peekLast()) {
                    deque.pollLast();
                }
                deque.add(nums[i]);
            } else {
                result[index++] = deque.peek();
                if (deque.peek() == nums[i-k]) {
                    deque.poll();
                }
                while (!deque.isEmpty() && nums[i]>deque.peekLast()) {
                    deque.pollLast();
                }
                deque.add(nums[i]);
            }
        }

        while (!deque.isEmpty() && index < result.length) {
            result[index++] = deque.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode239().maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3));
    }




}
