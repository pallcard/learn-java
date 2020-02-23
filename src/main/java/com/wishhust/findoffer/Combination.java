package com.wishhust.findoffer;

public class Combination {
    public void combination(String str) {
      for (int i = 1; i <= str.length(); i++) {
        combination(str, new StringBuilder(), 0, i);
      }
    }

    private void combination(String str, StringBuilder strTemp, int index, int length) {
      if (length == index) {
        System.out.println(new StringBuilder(strTemp));
        return;
      }
      for (int i = 0; i < str.length(); i++) {
        if (strTemp.toString().contains(""+str.charAt(i))) {
          break;
        }
        strTemp.append(str.charAt(i));
        combination(str, strTemp, index+1, length);
        strTemp.delete(strTemp.length()-1, strTemp.length());
      }
    }

  public static void main(String[] args) {
    new Combination().combination("abcd");
  }
}
