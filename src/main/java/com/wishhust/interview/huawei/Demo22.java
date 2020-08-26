package com.wishhust.interview.huawei;

import java.util.Scanner;

public class Demo22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] nums = str.split("],\\[");
        String[] xStr = nums[0].substring(1).split(",");
        String[] yStr = nums[1].substring(0, nums[1].length()-1).split(",");

        int [] x = new int[xStr.length];
        int [] y = new int[xStr.length];

        for (int i = 0; i < xStr.length; i++) {
            x[i] = Integer.parseInt(xStr[i]);
            y[i] = Integer.parseInt(yStr[i]);
        }

        int max = -1;
        for (int i = 0; i < xStr.length; i++) {
            int left = i-1;
            int right = i+1;
            int temp_x = x[i];
            int temp_y = y[i];
            while (left>=0 && y[left]>y[i]) {
                temp_x += x[left];
                left--;
            }
            while (right<xStr.length && y[right]>y[i]) {
                temp_x += x[right];
                right++;
            }
            max = Math.max(max, temp_x * temp_y);
        }
        System.out.println(max);
    }
}
