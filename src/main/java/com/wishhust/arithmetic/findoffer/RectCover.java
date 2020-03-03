package com.wishhust.arithmetic.findoffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
  public int RectCover(int target) {
    if (target <= 2) {
      return target;
    }
    int j1 = 1;
    int j2 = 2;
    int result = 0;
    for (int i = 2; i < target; i++) {
      result = j1 + j2;
      j1 = j2;
      j2 = result;
    }
    return result;
  }
}
