package com.wishhust.arithmetic.leetcode;

public class Leetcode154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        int mid;
        while (left < right) {
            if (left + 1 == right) {
                return Math.min(nums[left], nums[right]);
            }
            mid = (right - left)/2 + left;
            if (nums[left] > nums[mid]) {
                right = mid;
            } else if (nums[left] <= nums[right]) {
                return nums[left];
            } else  {
                left = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int min = new Leetcode154().findMin(new int[]{2, 2, 2, 0, 1});
        System.out.println(min);
    }
}
