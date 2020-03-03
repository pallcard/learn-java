package com.wishhust.arithmetic.findoffer;

public class BigNumAdd {

  public String bigNumAdd(String num1, String num2) {

    int index = 0;
    StringBuilder sb = new StringBuilder();
    int num1Index = num1.length()-1;
    int num2Index = num2.length()-1;
    int carry = 0;
    int sum = 0;
    while (num1Index >= 0 && num2Index >= 0) {
      int n1 = num1.charAt(num1Index--) - '0';
      int n2 = num2.charAt(num2Index--) - '0';
      sum = n1+n2+carry;
      carry = sum / 10;
      sb.append(sum%10);
    }

    while (num1Index>=0) {
      int n1 = num1.charAt(num1Index--) - '0';
      sum = n1 + carry;
      carry = sum / 10;
      sb.append(sum%10);
    }

    while (num2Index>=0) {
      int n2 = num2.charAt(num2Index--) - '0';
      sum = n2 + carry;
      carry = sum / 10;
      sb.append(sum%10);
    }

    if (carry > 0) {
      sb.append(carry);
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    String s = new BigNumAdd().bigNumAdd("118", "22222222");
    System.out.println(s);
  }
}
