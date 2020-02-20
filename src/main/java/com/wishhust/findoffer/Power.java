package com.wishhust.findoffer;

/**
 * 实现base的exponent次方
 */

public class Power {
  public double Power(double base, int exponent) {
    return Math.pow(base, exponent);
  }

  public double Power2(double base, int exponent) {
    double ret = 1;
    boolean isMinus = false;
    if (Double.compare(base, 0.0) == 0) {
      return 0;
    }
    if (exponent < 0) {
      isMinus = true;
      exponent = -exponent;
    }
    for (int i = 0; i < exponent; i++) {
      ret *= base;
    }
    if (isMinus) {
      ret = 1.0 / ret;
    }
    return ret;
  }

  double PowerUnsignedExponent(double base, int exponent) {
    if (exponent == 0) {
      return 1;
    }
    if (exponent == 1) {
      return base;
    }
    double ret = PowerUnsignedExponent(base, exponent >> 1);
    ret *= ret;
    // exponent & 0x1 代替 % 判断奇偶
    if ((exponent & 0x1) == 1) {
      ret *= base;
    }
    return ret;
  }

}
