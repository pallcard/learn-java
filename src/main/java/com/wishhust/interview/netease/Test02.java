package com.wishhust.interview.netease;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = 0;
        //0  1  2  3  4
        while (nums[0]>0 && nums[2]>0 && nums[4]>0) {
            res++;
            nums[0]--;
            nums[2]--;
            nums[4]--;
        }

        while (true) {
            if (nums[0]>0) {
                nums[0]--;
            } else if (nums[1]>0){
                nums[1]--;
            } else {
                break;
            }

            if (nums[4]>0) {
                nums[4]--;
            } else if (nums[3]>0){
                nums[3]--;
            } else {
                break;
            }

            if (nums[2]>0) {
                nums[2]--;
            } else if (nums[1]>nums[3] && nums[1]>0) {
                nums[1]--;
            } else if (nums[3]>nums[1] && nums[3]>0) {
                nums[3]--;
            } else if (nums[3]==nums[1] && nums[3]>0 && nums[0]>=nums[4]) {
                nums[1]--;
            } else if (nums[3] == nums[1] && nums[3] > 0) {
                nums[3]--;
            } else {
                break;
            }

            res++;

        }
        System.out.println(res);
    }
}
