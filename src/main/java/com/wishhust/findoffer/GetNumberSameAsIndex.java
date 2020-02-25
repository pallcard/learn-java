package com.wishhust.findoffer;

/**
 * 数组中数值与下标相等
 * 数组：单调递增每个元素唯一
 *
 *  0  1  2  3  4
 * -3 -1  1  3  5
 */
public class GetNumberSameAsIndex {
  public int getNumberSameAsIndex(int [] array) {
    int start = 0;
    int end = array.length-1;
    int mid;
    while (start <= end) {
      mid = start + (end-start)/2;
      if (array[mid]> mid) {
        end = mid-1;
      } else if (array[mid] < mid) {
        start = mid +1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int numberSameAsIndex = new GetNumberSameAsIndex()
        .getNumberSameAsIndex(new int[]{-3, -1, 1, 3, 5});
    System.out.println(numberSameAsIndex);
  }
}
