package com.wishhust.arithmetic.leetcode;

public class Leetcode343 {

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int result = 1;
        while (n>4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode343().integerBreak(10));
    }
}
