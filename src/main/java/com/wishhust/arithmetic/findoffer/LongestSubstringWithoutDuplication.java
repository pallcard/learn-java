package com.wishhust.arithmetic.findoffer;

/**
 * 最长不含重复字符的子字符串
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长字符串的长度。
 * 字符串中只含有 'a'-'z'
 *
 *
 * 1. 若字符str[i]未出现，或非当前子字符串中，则当前字符串长度+1
 * 2. 若str[i]当前子字符中，则重新计算当前字符的长度。
 *
 */
public class LongestSubstringWithoutDuplication {
  public int longestSubstringWithoutDuplication(String str) {
    int [] position = new int [26];

    // position 用于存放字符串中上一个字符小标
    for (int i = 0; i < position.length; i++) {
      position[i] = -1;
    }
    int curLength = 0;
    int maxLength = 0;
    for (int i = 0; i < str.length(); i++) {
      int index = position[str.charAt(i)-'a'];
      if (index < 0 || i-index > curLength) {
        curLength++;
      } else {
        curLength = i-index;
      }
      position[str.charAt(i)-'a'] = i;
      if (maxLength < curLength) {
        maxLength = curLength;
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    int count = new LongestSubstringWithoutDuplication()
        .longestSubstringWithoutDuplication("arabcacfr");
    System.out.println(count);
  }
}
