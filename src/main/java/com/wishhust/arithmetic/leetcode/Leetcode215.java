package com.wishhust.arithmetic.leetcode;

public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int pos = quickPart(nums, left, right);
            if (pos == k) {
                break;
            } else if (pos > k){
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
        return nums[k];
    }

    public int quickPart(int[] nums, int left, int right) {
        // 两个数
        if (right - left == 1) {
            if (nums[left] > nums[right]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                return right;
            } else {
                return left;
            }
        }
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right--];
            }

            while (left < right && nums[left] < temp) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left++];
            }
        }
        nums[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        int kthLargest = new Leetcode215().findKthLargest(new int[]{-1,2,0}, 1);
        System.out.println(kthLargest);
    }

}
