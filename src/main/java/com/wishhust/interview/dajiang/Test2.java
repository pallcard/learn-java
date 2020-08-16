package com.wishhust.interview.dajiang;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int [][] arr = new int[N][2];

        int[][] dp = new int[N][X];

        for (int i = 0; i < N; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = X-1; j >= 0; j++) {
                if (j-arr[i][1]>=0) {
                    dp[i][j] = Math.max(dp[i][j-arr[i][1]] + arr[i][0], dp[i][j]);
                } else {
                    dp[i][j] = dp[i][j];
                }

            }
        }

        System.out.println(dp[N-1][X-1]);


    }
}
