package com.wishhust.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuke on 2019/12/26 19:46
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * <p>返回 s 所有可能的分割方案。
 *
 * <p>示例:
 *
 * <p>输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */
public class Partition {

  public List<List<String>> partition(String s) {
    List<List<String>> re = new ArrayList<>();
    List<String> list = new ArrayList<>();
    dfsSearch(re, list, s, 0);
    return re;
  }

  public void dfsSearch(List<List<String>> re, List<String> list, String s, int start) {
    if (start == s.length()) {
      re.add(new ArrayList<>(list));
    }

    for (int i = start; i < s.length(); i++) {
      String substring = s.substring(start, i + 1);
      if (!isPalindrome(substring)) {
        continue;
      }
      list.add(substring);
      dfsSearch(re,list,s,i+1);
      list.remove(list.size()-1);
    }
  }

  public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length()-1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    //
    List<List<String>> ababa = new Partition().partition("cdd");
    System.out.println(ababa);
  }
}
