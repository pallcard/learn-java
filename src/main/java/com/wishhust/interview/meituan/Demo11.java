package com.wishhust.interview.meituan;

import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        test:
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            if (!((s.charAt(0) >= 'a' && s.charAt(0) <= 'z') || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z'))) {
                System.out.println("Wrong");
                continue;
            }
            boolean flag = false;
            for (int j = 1; j < s.length(); j++) {
                if (!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z' || (s.charAt(j)>= '0' && s.charAt(j)<= '9' )))) {
                    System.out.println("Wrong");
                    continue test;
                }
                if (s.charAt(j)>= '0' && s.charAt(j)<= '9' ) {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("Accept");
            }else {
                System.out.println("Wrong");
            }
        }

    }
}
