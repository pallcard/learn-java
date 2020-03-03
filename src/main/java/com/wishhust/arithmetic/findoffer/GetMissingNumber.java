package com.wishhust.arithmetic.findoffer;

/**
 * 0~n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中所有数字都唯一，并且每个数字都在范围0~n-1内。
 * 在范围0~n-1个数字中有且仅有一个数字不在改数组中，请找出这个数字
 *
 * 若数组不缺，则数组中数字与其下标对应，故找出数组中第一个数字大于小标的即可
 * 直接使用二分法查找即可
 */
public class GetMissingNumber {
  // 0 1 2 3 5 6
  public int getMissingNumber(int [] array) {
    int start = 0;
    int end = array.length;
    while (start <= end) {
      int mid = start + (end - start)/2;
      if (array[mid] > mid) {
        end = mid-1;
      } else if (array[mid] == mid) {
        start = mid+1;
      }
    }

    return start;

  }

  public static void main(String[] args) {
    int missingNumber = new GetMissingNumber().getMissingNumber(new int[]{1, 2, 3, 4,5, 6, 7,8});
    System.out.println(missingNumber);

  }
}
