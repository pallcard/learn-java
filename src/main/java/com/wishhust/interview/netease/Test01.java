package com.wishhust.interview.netease;

import java.util.HashMap;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double count = N *0.01;
        scanner.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        int res = 0;
        for (String word : map.keySet()) {
            if (map.get(word)>=count) {
                res++;
            }
        }
        System.out.println(res);
    }
}
