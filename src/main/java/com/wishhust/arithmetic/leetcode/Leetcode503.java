package com.wishhust.arithmetic.leetcode;

import java.util.Stack;

/**
 * 下一个更大元素 II
 *
 */
public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 2*n-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i%n]) {
                stack.pop();
            }
            result[i%n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%n]);
        }

        return result;
    }
}
