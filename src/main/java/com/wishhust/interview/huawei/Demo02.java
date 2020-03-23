package com.wishhust.interview.huawei;

public class Demo02 {
  // 192.168.0.1
  // abc 192.168.1

  public boolean isValid(String str) {
    if (null == str) {
      return false;
    }
    String[] split = str.split("\\.");
    if (split.length != 4) {
      return false;
    }
    for (int i = 0; i < split.length; i++) {
      if (toNum(split[i]) == -1) {
        return false;
      }
    }
    return true;
  }

  private int toNum(String num) {
    for (int i = 0; i < num.length(); i++) {
      if (num.charAt(i) < '0' || num.charAt(i) > '9') {
        return -1;
      }
    }
    int i = Integer.parseInt(num);
    if (i >= 0 && i <= 255) {
      return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    boolean valid = new Demo02().isValid("192.168.1");
    System.out.println(valid);
  }

}
