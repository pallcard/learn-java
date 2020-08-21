package com.wishhust.interview.huawei;

import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] count = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int d = scanner.nextInt();
            max = Math.max(max, d);
            count[d]++;
        }
        long res = 1;
        for (int i = 1; i <= max; i++) {
            res *= c(count[i], count[i-1]*2);
        }
        System.out.println(res%(Math.pow(10, 9)+7));
    }

    public static long c(int n, int m) {
        long s1 = 1;
        long s2 = 1;
        for (int i = 1; i <= n; i++) {
            s1 *= i;
            s2 *= (m-i+1);
        }
        return s2/s1;
    }
}
