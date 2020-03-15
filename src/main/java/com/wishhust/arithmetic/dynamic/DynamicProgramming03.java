package com.wishhust.arithmetic.dynamic;

public class DynamicProgramming03 {
  public int getMin(String str) {
    int [][] opt = new int[str.length()][str.length()];

    for (int l = 2; l <= str.length(); l++) {

      for (int j = l-1, i=0; j < str.length(); j++, i++) {
        if (str.charAt(i) == str.charAt(j)) {
          opt[i][j] = opt[i+1][j-1];
        } else {
          opt[i][j] = Math.min(opt[i+1][j], opt[i][j-1])+1;
        }
      }
    }

    return opt[0][str.length()-1];
  }

  public static void main(String[] args) {
    int leetcode = new DynamicProgramming03().getMin("leetcode");
    System.out.println(leetcode);
  }
}
