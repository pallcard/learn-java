package com.wishhust.findoffer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric {
  public boolean isNumeric(char[] str) {
    if (null == str || str.length == 0) {
      return false;
    }
    int index = 0;
    if (str[index] == '+' || str[index] == '-') {
      index++;
    }
    boolean dot = false;
    boolean e = false;
    while (index < str.length) {
      char c = str[index];
      if (c-'0'>=0 && c-'0'<=9) {
        index++;
      } else if (c == '.' && !e && !dot) {
        index++;
        dot = true;
      } else if ((c == 'e' || c == 'E') && !e && index+1<str.length) {
        if ((str[index+1] == '-' || str[index+1] == '+') && index+2<str.length) {
          index++;
        }
        index++;
        e = true;
      } else {
        return false;
      }
    }
    return index == str.length;
  }

  public boolean isNumeric(String str) {
    if (str.length() == 0) {
      return false;
    }
    int index = 0;
    if (str.charAt(0) == '+' || str.charAt(0) == '-') {
      index++;
    }
    boolean isNumber = false;
    boolean isNumberWithDot = false;
    boolean isNumberWithE = false;

    while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
      index++;
      isNumber = true;
    }

    if (index < str.length() && str.charAt(index) == '.') {
      index++;
      while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
        index++;
        isNumberWithDot = true;
      }
      isNumber = isNumberWithDot;
    }

    if (index < str.length() && (str.charAt(index) == 'e' || str.charAt(index) == 'E')) {
      index++;

      if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
        index++;
      }
      while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
        index++;
        isNumberWithE=true;
      }
      isNumber = isNumber && isNumberWithE;

    }

    if (index == str.length()) {
      return isNumber;
    }

    return false;
  }

  public static void main(String[] args) {
    boolean numeric = new IsNumeric().isNumeric(".2e+6".toCharArray());

    boolean numeric1 = new IsNumeric().isNumeric(".2e");
    System.out.println(numeric1);
  }

}
