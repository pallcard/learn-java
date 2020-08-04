package com.wishhust.arithmetic.leetcode;


public class Leetcode415 {
    public String addStrings(String num1, String num2) {
        int d = 0;
        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();
        StringBuilder result = new StringBuilder(num1.length());
        int index = 0;
        while (index < sb1.length() && index < sb2.length()) {
            int res = (sb1.charAt(index)-'0') + (sb2.charAt(index)-'0') + d;
            result = result.append(res % 10);
            d = res / 10;
            index++;
        }
        while (index < sb1.length()) {
            int res = (sb1.charAt(index)-'0') + d;
            result = result.append(res % 10);
            d = res / 10;
            index++;
        }

        while (index < sb2.length()) {
            int res = (sb2.charAt(index)-'0') + d;
            result = result.append(res % 10);
            d = res / 10;
            index++;
        }
        if (d > 0) {
            result = result.append(d);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode415().addStrings("125", "456"));
    }
}
