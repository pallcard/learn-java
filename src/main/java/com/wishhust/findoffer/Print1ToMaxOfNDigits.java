package com.wishhust.findoffer;

/**
 * 输入数字n，按顺序打印从1到最大的n位十进制数。比如输入3，则打印1，2，3，4 ... 999.
 *
 * 1. 数值可能过大， int long 无法存下
 */
public class Print1ToMaxOfNDigits {
  void print1ToMaxOfNDigits(int n) {
    int num = 1;
    double max = Math.pow(10, n);
    while (num < max) {
      System.out.println(num++);
    }

  }

  void print1ToMaxOfNDigits2(int n) {
    char[] numStr = new char[n];
    dfs(0, numStr, n);
  }

  private void dfs(int index, char[] numStr, int n) {
    if (index == n) {
      printNum(numStr);
      return;
    }
    for (int i = 0; i < 10; i++) {
      numStr[index] = (char) ('0'+i);
      dfs(index+1, numStr, n);
    }
  }

  private void printNum(char [] num) {
    StringBuilder sb = new StringBuilder();
    int index = 0;
    while (index < num.length && num[index] == '0') {
      index++;
    }
    for (int i = index; i < num.length; i++) {
        sb.append(num[i]);
    }
    if (sb.length() == 0) {
      System.out.println("0");
    } else {
      System.out.println(sb.toString());
    }
  }

  public static void main(String[] args) {
//    new Print1ToMaxOfNDigits().print1ToMaxOfNDigits(3);
    new Print1ToMaxOfNDigits().print1ToMaxOfNDigits2(3);
  }
}
