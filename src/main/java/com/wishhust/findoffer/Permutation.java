package com.wishhust.findoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {
  public ArrayList<String> Permutation(String str) {
    ArrayList<String> list = new ArrayList<>();
    if (str.length() == 0) {
      return list;
    }
    StringBuilder sb = new StringBuilder(str.length());
    boolean [] visited = new boolean[str.length()];
    dfs(str, list, sb, visited);
    return list;
  }

  private void dfs(String str, List<String> list, StringBuilder sb, boolean [] visited) {
    if (sb.length() == str.length()) {
      if (!list.contains(sb.toString())) {
        list.add(sb.toString());
      }
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      if (!visited[i]) {
        sb.append(str.charAt(i));
        visited[i] = true;
        dfs(str, list,sb, visited);
        visited[i] = false;
        sb.delete(sb.length()-1, sb.length());
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<String> abc = new Permutation().Permutation("abc");
    System.out.println(abc);
  }
}
