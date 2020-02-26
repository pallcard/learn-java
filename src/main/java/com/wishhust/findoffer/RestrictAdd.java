package com.wishhust.findoffer;

import javax.xml.ws.soap.Addressing;

/**
 *
 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class RestrictAdd {

  public int add(int num1, int num2) {
    do {
      int carry = (num1 & num2) << 1;
      int add = num1 ^ num2;
      num1 = add;
      num2 = carry;
    } while (num2 != 0);
    return num1;
  }

  public static void main(String[] args) {
    System.out.println(new RestrictAdd().add(111,459));
  }
}
