package com.wishhust.findoffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 1 2 3 4 5 6
 * 1 3 5 2 4 6
 */
public class ReOrderArray {
  public void reOrderArray(int [] array) {
    int oddIndex = 0;
    int index = 0;
    while (index < array.length) {
      while (array[oddIndex] % 2 != 0) {
        oddIndex++;
        index++;
        if (oddIndex >= array.length) {
          return;
        }
      }
      while (array[index] % 2 == 0) {
        index++;
        if (index >= array.length) {
          return;
        }
      }
      while (oddIndex < index) {
        int temp = array[index];
        array[index] = array[index-1];
        array[index-1] = temp;
        index--;
      }
    }
  }

  // 空间换时间
  public void reOrderArray2(int [] array) {
    int [] oddArray = new int[array.length];
    int oddIndex = 0;
    int [] evenArray = new int[array.length];
    int evenIndex = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] % 2 == 1) {
        oddArray[oddIndex++] = array[i];
      } else {
        evenArray[evenIndex++] = array[i];
      }
    }
    int index = 0;
    for (int i = 0; i < oddIndex; i++) {
      array[index++] = oddArray[i];
    }
    for (int i = 0; i < evenIndex; i++) {
      array[index++] = evenArray[i];
    }
  }

  public static void main(String[] args) {
    int[] ints = {1,2,3,4,5,6};
    new ReOrderArray().reOrderArray2(ints);
    System.out.println(ints);
  }
}
