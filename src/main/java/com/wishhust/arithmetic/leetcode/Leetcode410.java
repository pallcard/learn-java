package com.wishhust.arithmetic.leetcode;


/**
 * 分割数组的最大值
 * 将数组nums分割成m个连续的子数组，使得分割的子数组各自和最大值最小，最小值多少
 * <p>
 * 分析：
 * 这个最小值在 max(nums) --- sum(nums)，
 * 采用二分法在这个区间找符合要求的最小值
 */
public class Leetcode410 {
    public int splitArray(int[] nums, int m) {
        int left = 0;  // max(nums)
        int right = 0; // sum(nums)

        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }

        int min = right;
        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (check(nums, m, mid)) {
                min = mid;
                right = mid;
            } else {
                left = mid+1;
            }

        }
        return min;
    }

    private boolean check(int[] nums, int m, int mid) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                count++;
                sum = nums[i];
            }
        }
        if (count <= m) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode410().splitArray(new int[] {1,4,4}, 3));
    }


}
