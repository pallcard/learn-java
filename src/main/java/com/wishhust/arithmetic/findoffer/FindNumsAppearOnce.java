package com.wishhust.arithmetic.findoffer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {

  public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
    int temp = 0;
    for (int i = 0; i < array.length; i++) {
      temp ^= array[i];
    }
    String binaryString = Integer.toBinaryString(temp);
    int indexOf1 = binaryString.length() - binaryString.lastIndexOf("1");

    num1[0] = 0;
    num2[0] = 0;
    for (int i = 0; i < array.length; i++) {
      String str = Integer.toBinaryString(array[i]);
      if (str.length() > indexOf1 && str.charAt(str.length()-indexOf1) == '1') {
        num1[0] ^= array[i];
      } else {
        num2[0] ^= array[i];
      }
    }
  }

  public static void main(String[] args) {
    int[] num1 = new int[1];
    int[] num2 = new int[1];
    new FindNumsAppearOnce().FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5}, num1, num2);
    System.out.println(num1[0]+" "+num2[0]);

  }
}
