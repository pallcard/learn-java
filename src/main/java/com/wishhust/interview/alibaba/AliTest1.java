package com.wishhust.interview.alibaba;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AliTest1 {

  public int input(){
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    List<String> strs = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      strs.add(scanner.nextLine());
    }
    strs.sort(Comparator.comparingInt(a -> a.charAt(a.length() - 1)));
    return getMax(strs);
  }

  public int getMax(List<String> strs) {
    int[] opt = new int [strs.size()];
    int [] next = new int[strs.size()];

    for (int i = strs.size()-1; i > 0; i--) {
      int j = i;
      while (j-1>=0 && strs.get(j).charAt(0) < strs.get(j-1).charAt(strs.get(j-1).length()-1)) {
        j--;
      }
      next[i] = j-1;
    }

    opt[0] = strs.get(0).length();
    for (int i = 1; i < strs.size(); i++) {
      if (next[i] < 0) {
        opt[i] = Math.max(strs.get(i).length(), opt[i-1]);
      } else {
        opt[i] = Math.max(opt[next[i]] + strs.get(i).length(), opt[i-1]);
      }
    }
    return opt[strs.size()-1];
  }

  // n个非递减的字符串，拼出非递减的最长的字符串。
  // 输入： 4
  //        aaa
  //        bcd
  //        zzz
  //        bcdef
  // 输出： 11

  public static void main(String[] args) {

    int input = new AliTest1().input();
    System.out.println(input);
  }
}
