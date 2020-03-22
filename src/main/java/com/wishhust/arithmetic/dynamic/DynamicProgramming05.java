package com.wishhust.arithmetic.dynamic;

public class DynamicProgramming05 {

  public static void main(String[] args) {
    boolean subSet = new DynamicProgramming05().findSum2(new int[]{4,1,1,9,1}, 8);
    System.out.println(subSet);
  }

  private boolean findSum(int[] nums, int target) {
    return subSet(nums, nums.length-1, target);
  }

  private boolean subSet(int[] nums, int i, int target) {

    if (target == 0) {
      // 找到目标值
      return true;
    }
    if (target < nums[i]) {
      // 不选
      return subSet(nums, i-1, target);
    }
    if (i == 0) {
      // 只剩一个数
      return nums[0] == target;
    }

    return subSet(nums, i-1, target-nums[i]) || subSet(nums, i-1, target);
  }


  private boolean findSum2(int[] nums, int target) {

    boolean [][] subSet = new boolean [nums.length][target+1];

    for (int i = 0; i < subSet[0].length; i++) {
      subSet[0][i] = (nums[0] == i);
    }

    for (int i = 0; i < subSet.length; i++) {
      subSet[i][0] = true;
    }

    for (int i = 1; i < subSet.length; i++) {
      for (int j = 1; j < subSet[0].length; j++) {
        if (nums[i] > j) {
          subSet[i][j] = subSet[i-1][j];
        } else {
          subSet[i][j] = subSet[i-1][j-nums[i]] || subSet[i-1][j];
        }
      }
    }

    return subSet[subSet.length-1][subSet[0].length-1];
  }

}
