package com.wishhust.leetcode;

/**
 * Created by liuke on 2019/12/24 19:49
 *
 * <p>验证回文串 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * <p>说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * <p>示例 1:
 *
 * <p>输入: "A man, a plan, a canal: Panama" 输出: true 示例 2:
 *
 * <p>输入: "race a car" 输出: false
 */
public class IsPalindrome {
  public boolean isPalindrome(String s) {
    if (s.equals("")) {
      return true;
    }
    int i = 0;
    int j = s.length() - 1;
    String strLow = s.toLowerCase();
    while (i < j) {
      while (i < strLow.length() && !isNumOrLetter(strLow.charAt(i))) {
        i++;
      }
      while (j >= 0 && !isNumOrLetter(strLow.charAt(j))) {
        j--;
      }
      if (i > j) {
        return true;
      }
      if (strLow.charAt(i) != strLow.charAt(j)) {
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }

  public boolean isNumOrLetter(char c) {
    if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    boolean palindrome = new IsPalindrome().isPalindrome(".,");
    System.out.println(palindrome);
  }
}
