package com.wishhust.arithmetic.leetcode;

public class Offer03 {
//
//    2, 3, 1, 0, 2, 5, 3
    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] && nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            while (i != nums[i]) {

                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int repeatNumber = new Offer03().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(repeatNumber);
    }
}
