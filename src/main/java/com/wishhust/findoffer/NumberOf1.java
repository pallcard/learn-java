package com.wishhust.findoffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 相关题目：（剑指offer p103）
 * 1. 判断一个整数是不是2的整数次方
 * 2. 输入两个整数m和n，计算需要改变m的二进制中多少位能得到n
 */
public class NumberOf1 {
  public int NumberOf1(int n) {
    int count = 0;
    String binaryString = null;
//    if (n > 0) {
      binaryString = Integer.toBinaryString(n);
      for (int i = 0; i < binaryString.length(); i++) {
        if (binaryString.charAt(i) == '1') {
          count++;
        }
      }
//    } else if (n == Integer.MIN_VALUE) {
//      // 处理 -2147483648  =>补码 100 0000 0000 0000
//      return 1;
//    } else {
//      binaryString = Integer.toBinaryString(-n);
//      int indexRight1 = binaryString.lastIndexOf("1");
//      for (int i = 0; i <= indexRight1; i++) {
//        if (binaryString.charAt(i) == '0') {
//          count++;
//        }
//      }
//    }
    return count;
  }

  public int NumberOf1(int n, int id) {
    int count = 0;
    int flag = 1;
    while (flag != 0) {
      if ((n & flag) != 0) {
        count++;
      }
      flag <<= 1;
    }
    return count;
  }

  public int NumberOf1(int n, String id) {
    int count = 0;
    while (n != 0) {
        count++;
      n = n & (n-1);
    }
    return count;
  }

  public static void main(String[] args) {
    int i = new NumberOf1().NumberOf1(-1);
    int j = new NumberOf1().NumberOf1(1, 1);
    System.out.println(j);
    System.out.println(i);
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//    v-2147483648
  }
}
