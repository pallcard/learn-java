package com.wishhust.arithmetic.leetcode;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        double sum = 0;

        for (int i = 0; i < 2*N; i++) {
            sum += 1.0 / (5 * (i + 1)) * Math.pow(-1, i);
        }

        BigDecimal b = new BigDecimal(sum);

        System.out.printf("%.4f\n", b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());

    }
}
