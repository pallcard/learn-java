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

    /**
     *
     * @param nums 原数组
     * @param m    切分的个数m
     * @param max  最大值mid
     * @return
     */
    private boolean check(int[] nums, int m, int max) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                count++;
                sum = nums[i];
            }
        }
        // 注意这里是 <=
        // 划分的组数小于m时，是满足要求的，
        if (count <= m) {
            return true;
        }
        return false;
    }

    // 是用dp解
    // dp[i][j] 前i个元素，划分为j组时的最小值
    // dp[i][1] 前i个元素，划分为1组的，则对应为 sum(0--i)

    // 找dp[i][j] dp[i][j-1]关系
    // 是用一个"挡板"K，将前i个元素切分，K范围是 1--(i-1)
    // 划分成的两组是 dp[K][j-1], [K+1, i]，此时 dp[i][j] 为 max(dp[k][j-1], sum(K+1 -- i))最小的一个

    // 一个技巧：数组的前缀和，通过前缀和可以很方便的求sum(a--b)
    public int splitArray2(int[] nums, int m) {
        // 前缀和
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        int[][] dp = new int[nums.length][m+1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        // 分成1组
        for (int i = 0; i < nums.length; i++) {
            dp[i][1] = sum[i];
        }

        // 第2--m组
        for (int j = 2; j < m+1; j++) {
            for (int i = 1; i < dp.length; i++) {
                // 挡板K
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sum[i]-sum[k]));
                }
            }
        }

        return dp[nums.length-1][m];
    }


    public static void main(String[] args) {
        System.out.println(new Leetcode410().splitArray(new int[] {1,4,4}, 3));
        System.out.println(new Leetcode410().splitArray2(new int[] {1,4,4}, 3));
    }


}
