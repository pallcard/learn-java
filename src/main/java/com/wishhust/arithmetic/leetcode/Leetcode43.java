package com.wishhust.arithmetic.leetcode;

/**
 *   字符串相乘
 *
 *
 *    1 2 3
 *    4 5 6
 *    -----
 *    7 3 8
 *  6 1 5
 *4 9 2
 *---------
 *
 *
 */
public class Leetcode43 {

    public static void main(String[] args) {

        System.out.println(new Leetcode43().multiply("123", "456"));

    }

    public String multiply(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        sb1 = sb1.reverse();
        sb2 = sb2.reverse();
        int d = 0;
        StringBuilder sum1 = new StringBuilder();
        StringBuilder sum2 = new StringBuilder();
        sum2.append(0);
        for (int i = 0; i < sb1.length(); i++) {
            for (int k = 0; k < i; k++) {
                sum1.append("0");
            }
            for (int j = 0; j < sb2.length(); j++) {
                int res = (sb1.charAt(i)- '0') * (sb2.charAt(j)- '0') + d;
                sum1.append(res%10);
                d = res / 10;
            }
            if (d > 0) {
                sum1.append(d);
                d = 0;
            }
            sum2 = add(sum1, sum2);
            sum1 = new StringBuilder();
        }

        StringBuilder res = sum2.reverse();
        int zeroIndex = 0;
        for (int i = 0; i < res.length(); i++) {
            if (sum2.charAt(i) == '0') {
                zeroIndex++;
            } else {
                break;
            }
        }
        if (zeroIndex == res.length()) {
            return "0";
        }

        return res.substring(zeroIndex);

    }

    public StringBuilder add(StringBuilder num1, StringBuilder num2) {
        int index = 0;
        int d = 0;
        StringBuilder sum = new StringBuilder();

        while (index < num1.length() && index < num2.length()) {
            int res = (num1.charAt(index) - '0') + (num2.charAt(index) - '0') + d;
            sum.append(res % 10);
            d = res / 10;
            index++;
        }

        while (index < num1.length()) {
            int res = (num1.charAt(index) - '0')  + d;
            sum.append(res % 10);
            d = res / 10;
            index++;
        }

        while (index < num2.length()) {
            int res = (num2.charAt(index) - '0') + d;
            sum.append(res % 10);
            d = res / 10;
            index++;
        }

        if (d > 0) {
            sum.append(d);
        }

        return sum;

    }
}
