package com.wishhust.findoffer;

/**
 * 数组中唯一只出现了一次的数字
 * 在一个数组中除了一个数字只出现一次之外，其他数字出现3次，找出那个只出现一次的数字。
 */
public class FindNumberAppearingOnce {
  public int FindNumberAppearingOnce(int [] array) {
    int [] bin = new int[32];
    for (int i = 0; i < array.length; i++) {
      String numBin = Integer.toBinaryString(array[i]);
      int index = 0;
      for (int j = numBin.length()-1; j >= 0; j--) {
        bin[index++] += (numBin.charAt(j)-'0');
      }
    }
    int ret = 0;
    for (int i = 0; i < bin.length; i++) {
      ret += (bin[i] % 3)*Math.pow(2, i);
    }
    return ret;
  }

  public static void main(String[] args) {
    int i = new FindNumberAppearingOnce().FindNumberAppearingOnce(new int[]{1, 2, 2, 2, 3, 3, 3});
    System.out.println(i);
  }

}
