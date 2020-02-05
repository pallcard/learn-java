package com.wishhust.findoffer;

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

  public static void main(String[] args) {
    int i = new NumberOf1().NumberOf1(-1);
    System.out.println(i);
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//    v-2147483648
  }
}
