package com.wishhust.interview.huawei;


import java.util.Scanner;

public class Demo21 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] nums = str.split(" ");

        StringBuilder[] numsSb = new StringBuilder[nums.length];

        for (int i = 0; i < nums.length; i++) {
            long num = Long.parseLong(nums[i]);
            String s = Long.toBinaryString(num);

            numsSb[i] = new StringBuilder(s);
            while (numsSb[i].length() < 32) {
                numsSb[i].insert(0, 0);
            }
            for (int j = 0; j < numsSb[i].length(); j+=2) {
                char c = numsSb[i].charAt(j);
                numsSb[i].setCharAt(j, numsSb[i].charAt(j+1));
                numsSb[i].setCharAt(j+1, c);
            }
        }

        nums[0] = numsSb[numsSb.length-1].substring(numsSb[numsSb.length-1].length()-2)+numsSb[0].substring(0, numsSb[0].length()-2);
        for (int i = 1; i < numsSb.length; i++) {
            nums[i] = numsSb[i-1].substring(nums[i-1].length()-2)+ numsSb[i].substring(0, numsSb[i].length()-2);
        }


        for (int i = 0; i < nums.length; i++) {
            System.out.print(Long.parseLong(nums[i],2)+ " ");
        }
    }
}
