package com.wishhust.arithmetic.findoffer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
  public int StrToInt(String str) {
    if (null == str || str.trim().length()==0) {
      return 0;
    }
    int sign = 1;
    String unSignedStr = null;
    if (str.charAt(0) == '+' ) {
      unSignedStr = str.substring(1);
    } else if (str.charAt(0) == '-') {
      sign = -1;
      unSignedStr = str.substring(1);
    } else {
      unSignedStr = str;
    }
    long ret = 0;
    for (int i = 0; i < unSignedStr.length(); i++) {
      char c = unSignedStr.charAt(i);
      if (c >='0' && c <= '9') {
        ret = (long) (ret + sign * (c-'0') * Math.pow(10, unSignedStr.length()-i-1));
      } else {
        return 0;
      }
    }
    if (ret <= Integer.MAX_VALUE && ret >= Integer.MIN_VALUE) {
      return (int)ret;
    } else {
      return 0;
    }

  }
}
