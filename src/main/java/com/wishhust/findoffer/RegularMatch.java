package com.wishhust.findoffer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 */
public class RegularMatch {
  public boolean match(char[] str, char[] pattern) {
    int strIndex = 0;
    int patternIndex = 0;
    for (; strIndex < str.length && patternIndex < pattern.length; ) {
      if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex]=='.') {
        strIndex++;
        patternIndex++;
      } else if (patternIndex+1 < pattern.length && pattern[patternIndex+1]=='*') {
        patternIndex += 2;
      }
    }
    if (strIndex == str.length && patternIndex == pattern.length) {
      return true;
    } else if((pattern.length-patternIndex) % 2 == 0) {
      while (patternIndex < pattern.length) {
        if (pattern[patternIndex] != '*' && pattern[patternIndex] != '.' && pattern[patternIndex+1] == '*') {
          patternIndex += 2;
        } else {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
//    boolean match = new RegularMatch().match(new char[]{'a', 'a', 'a'}, new char[]{'a', 'b','*', 'a','c','*', 'a'});
    boolean match = new RegularMatch().match(new char[]{'a', 'a', 'a'}, new char[]{'a', 'a','*', 'a','c','*', 'a'});
    System.out.println(match);
  }
}
