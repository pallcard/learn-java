package com.wishhust.findoffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {

  public int GetNumberOfK(int[] array, int k) {
    if (array.length == 0) {
      return 0;
    }
    int left = 0;
    int right = array.length - 1;
    int mid = 0;
    while (left <= right) {
      mid = (left + right) / 2;
      if (array[mid] == k) {
        break;
      } else if (array[mid] < k) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }
    int count = 0;
    if (array[mid] == k) {
      count++;
      for (int i = mid-1; i >=0; i--) {
        if (array[i] == k) {
          count++;
        }
      }
      for (int i = mid+1; i < array.length; i++) {
        if (array[i] == k) {
          count++;
        }
      }
    }
    return count;
  }
}
