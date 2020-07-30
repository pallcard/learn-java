package com.wishhust.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素 I
 *
 * 是用单调栈，
 *
 * 从后向前依次进行压榨，进行压栈时，要弹出栈中小于待压栈的元素，然后进行压栈，
 * 形成了一个从栈顶到栈底递增到栈  ===> 单调栈
 *
 */

public class Leetcode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        // nums[i], next
        // [1,3,4,2]
        // [3,4,-1,-1]
        Map<Integer, Integer> nextMap = new HashMap<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            // 弹出栈中小于nums2[i]的元素
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            int next = stack.isEmpty() ? -1 : stack.peek();
            nextMap.put(nums2[i], next);
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextMap.get(nums1[i]);
        }
        return result;
    }


}
