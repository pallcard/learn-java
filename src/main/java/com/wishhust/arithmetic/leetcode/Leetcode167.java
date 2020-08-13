package com.wishhust.arithmetic.leetcode;


/**
 * 两数之和 II - 输入有序数组
 */
public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left+1, right+1};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else{
                right--;
            }

        }
        return new int[]{-1,-1};
    }
}
