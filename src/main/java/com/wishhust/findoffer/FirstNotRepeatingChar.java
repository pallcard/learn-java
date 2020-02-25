package com.wishhust.findoffer;

import java.util.Arrays;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {

  public static void main(String[] args) {
    int google = new FirstNotRepeatingChar().FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp");
    System.out.println(google);
  }
  public int FirstNotRepeatingChar(String str) {
    int [] res = new int[26*2+6];

    // -1 未出现  -2出现两次及以上
    Arrays.fill(res, -1);

    for (int i = 0; i < str.length(); i++) {
      int index = str.charAt(i)-'A';
      if (res[index] == -1) {
        res[index] = i;
      } else if (res[index] >= 0) {
        res[index] = -2;
      }
    }
    int minIndex = 10001;
    for (int i = 0; i < res.length; i++) {
      if (res[i] >= 0 && minIndex > res[i]) {
        minIndex = res[i];
      }
    }

    return minIndex==10001? -1: minIndex;
  }
}
