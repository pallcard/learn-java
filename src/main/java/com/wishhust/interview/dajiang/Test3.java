package com.wishhust.interview.dajiang;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder(s);
        int N = scanner.nextInt();

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < sb.length()-1; j++) {
                if (sb.charAt(j) > sb.charAt(j+1)) {
                    sb.deleteCharAt(j);
                    count++;
                    break;
                }
            }
        }
        if (count<N) {
            sb.delete(sb.length()-(N-count), sb.length());
        }

        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        System.out.println(sb.toString());

    }
}
