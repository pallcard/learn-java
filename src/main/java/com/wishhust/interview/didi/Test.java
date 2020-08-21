package com.wishhust.interview.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<List<Integer>> list = new ArrayList<>();


        for (int i = 1; i < N/2/100+1; i++) {
            for (int j = 0;  j < 9; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0;  k < 9; k++) {
                    if (k==i || k==j) {
                        continue;
                    }
                    int x = i*100+j*10+k;
                    int y = i*100+k*11;
                    if (x+y == N) {
                        List<Integer> nums = new ArrayList<>();
                        nums.add(x);
                        nums.add(y);
                        list.add(nums);
                    }
                }
            }
        }
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get(0) + " " + list.get(i).get(1));

        }
    }
}
