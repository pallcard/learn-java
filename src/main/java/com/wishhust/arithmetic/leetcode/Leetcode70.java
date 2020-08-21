package com.wishhust.arithmetic.leetcode;

public class Leetcode70 {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;

        for (int i = 3; i <= n; i++) {
            int sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return f2;
    }
}
