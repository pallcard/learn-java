package com.wishhust.arithmetic.findoffer;

/**
 * 数字序列中某一位的数字
 * 数字以012345678910111213141516....的格式序列化到一个字符序列中。
 * 求任意第n位对应的数字。
 *
 * 1. 先确定第n位在第几位数字中
 *   1位数字（0-9）    10
 *   2位数字（10-99）  90
 *   3位数字（100-999）  900
 *
 * 2. 在对应的数字中找
 *
 */
public class DigitAtIndex {

  public int digitAtIndex(int index) {
    if (index < 0) {
      return -1;
    }
    int digits = 1;
    while (true) {
      if (index <= countNum(digits)*digits) {
        return findIndex(index, digits);
      }
      index -= countNum(digits)*digits;
      digits++;
    }
  }

  private int findIndex(int index, int digits) {
    int start = index / digits;
    if (index % digits == 0) {
      return (beginNum(digits) + start - 1) % 10;
    } else {
      return (beginNum(digits) + start) / ((int) Math.pow(10, digits-index % digits)) %10;
    }
  }

  private int beginNum(int digits) {
    if (digits == 1) {
      return 0;
    }
    return (int) Math.pow(10, digits-1);
  }


  private int countNum(int digits) {
    if (digits == 1) {
      return 10;
    } else {
      return (int) (9 * Math.pow(10, digits-1));
    }
  }

  public static void main(String[] args) {
    int i = new DigitAtIndex().digitAtIndex(16);
    System.out.println(i);
  }

}
