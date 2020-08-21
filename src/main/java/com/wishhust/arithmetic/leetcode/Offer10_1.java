package com.wishhust.arithmetic.leetcode;

public class Offer10_1 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        long f1 = 1;
        long f2 = 1;

        for (int i = 3; i <= n; i++) {
            long sum = f1 + f2;
            f1 = f2%((long)Math.pow(10, 9)+7);
            f2 = sum%((long)Math.pow(10, 9)+7);
        }
        System.out.println(f2);
        return (int)(f2%((long)Math.pow(10, 9)+7));
    }

}
