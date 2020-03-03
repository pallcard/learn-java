package com.wishhust.arithmetic.findoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class StringStream {

  private StringBuilder stringBuilder = new StringBuilder();
  //Insert one char from stringstream
  public void Insert(char ch)
  {
     stringBuilder.append(ch);
  }
  //return the first appearence once char in current stringstream
  public char FirstAppearingOnce()
  {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < stringBuilder.length(); i++) {
      char c = stringBuilder.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c)+1);
      } else {
        map.put(c, 1);
      }
    }

    for (int i = 0; i < stringBuilder.length(); i++) {
      char c = stringBuilder.charAt(i);
      if (map.get(c) == 1) {
        return c;
      }
    }
    return '#';
  }
}
