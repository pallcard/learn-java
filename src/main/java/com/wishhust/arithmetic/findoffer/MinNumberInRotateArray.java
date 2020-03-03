package com.wishhust.arithmetic.findoffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 1. {1,0,1,1,1}数组的处理，即 array[left] == array[mid] && array[mid] == array[right]需要顺序查找最小值
 * 2. array[left] <= array[mid]  则mid在左边
 * 3. array[mid] <= array[right] 则mid在右边
 * 4. array[left] < array[right] 则整个数组非递减，最小值为array[left]
 */
public class MinNumberInRotateArray {
//  {1,0,1,1,1} 有问题返回为1
  public int minNumberInRotateArray(int [] array) {
    if (array.length == 0) {
      return 0;
    }
    int left = 0;
    int right = array.length-1;
    int mid = (left + right) /2;
    while (left < right) {
      if (array[mid] >= array[left] && array[mid] <= array[right]) {
          return array[left];
      } else if (array[mid] >= array[left]) {
        left = mid+1;
      } else {
        right = mid;
      }
      mid = (left + right) /2;
    }
    return array[left];
  }

  public int minNumberInRotateArray2(int [] array) {
    if (array.length == 0) {
      return 0;
    }
    int left = 0;
    int right = array.length-1;
    int mid = left;
    while (array[left] >= array[right]) {
      if (right-left == 1) {
        mid = right;
        break;
      }

      mid = (left+right)/2;

      if (array[left] == array[mid] && array[mid] == array[right]) {
        return findMinInOrder(array, left, right);
      }

      if (array[mid] >= array[left]) {
        left = mid;
      } else if (array[mid] <= array[right]) {
        right = mid;
      }
    }

    return array[mid];
  }

  private int findMinInOrder(int [] array, int left, int right) {
    int min = Integer.MAX_VALUE;
    for (int i = left; i <= right; i++) {
      if (min > array[i]) {
        min = array[i];
      }
    }
    return min;
  }

  public static void main(String[] args) {
//    int result = new MinNumberInRotateArray().minNumberInRotateArray2(new int[]{1,0,1,1,1});
    int result = new MinNumberInRotateArray().minNumberInRotateArray2(new int[]{2,3,4,5,1});
    System.out.println(result);
  }
}
