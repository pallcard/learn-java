package com.wishhust.findoffer;

/**
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 *
 */
public class FindGreatestSumOfSubArray {
  public int FindGreatestSumOfSubArray(int[] array) {
    int max = Integer.MIN_VALUE;
    int [] dp = new int[array.length];
    dp[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      dp[i] = Math.max(dp[i-1]+array[i],array[i]);
      max = Math.max(dp[i], max);
    }
    return max;
  }

  public static void main(String[] args) {
    int max = new FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(new int[]{-2,-8,-1,-5,-9});
    System.out.println(max);
  }
}
