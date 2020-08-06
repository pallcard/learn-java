package com.wishhust.arithmetic.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] course = new int[n][2];
        for (int i = 0; i < n; i++) {
            course[i][0] = scanner.nextInt();
            course[i][1] = scanner.nextInt();
        }

        Arrays.sort(course, Comparator.comparingInt(a -> a[1]));

        int max = 1;

        for (int i = 0; i < course.length; i++) {
            int x_end = course[i][1];
            int count = 1;
            for (int j = i+1; j < course.length; j++) {
                if (x_end>course[j][0]) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
        System.out.printf("%0.2f", 1.23342342);
    }
}
