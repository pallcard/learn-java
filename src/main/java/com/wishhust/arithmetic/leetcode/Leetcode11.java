package com.wishhust.arithmetic.leetcode;

public class Leetcode11 {

    // 暴力解
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                res = Math.max(res,Math.min(height[i], height[j])*(j-i));
            }
        }
        return res;
    }


    // 双指针解法
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while (left < right) {
            res = Math.max(res,Math.min(height[left], height[right])*(right-left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }


}
