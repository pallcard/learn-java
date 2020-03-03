package com.wishhust.arithmetic.findoffer;


/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 * 
 */
public class PrintMinNumber {
  public String PrintMinNumber(int [] numbers) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numbers.length; i++) {
      int max = -1;
      int maxIndex = 0;
      for (int j = 0; j < numbers.length; j++) {
        if (numbers[j] == -1) {
          continue;
        }
        if (comp(max, numbers[j]) < 0) {
          max = numbers[j];
          maxIndex = j;
        }
      }
      numbers[maxIndex] = -1;
      sb.append(max);
    }
    return sb.toString();
  }

  // comp可以改成ab 与ba进行比较即可
  
  private int comp(int a, int b) {
    if (a == -1) {
      return -1;
    }
    if (b==-1) {
      return 1;
    }
    if (a==b) {
      return 1;
    }
    String strA = ""+a;
    String strB = ""+b;
    int index = 0;
    for (index = 0; index < strA.length() && index < strB.length(); index++) {
      if (strA.charAt(index) > strB.charAt(index)) {
        return -1;
      } else if (strA.charAt(index) < strB.charAt(index)){
        return 1;
      }
    }
    char lastChar = strA.charAt(index-1);

    while (index < strA.length()) {
      if(strA.charAt(index) < lastChar) {
        return 1;
      } else if (strA.charAt(index) > lastChar) {
        return -1;
      } else {
        index++;
      }
    }
    while (index < strB.length()) {
      if(strB.charAt(index) < lastChar) {
        return -1;
      } else if (strB.charAt(index) > lastChar) {
        return 1;
      } else {
        index++;
      }
    }
    return 0;
  }
}
