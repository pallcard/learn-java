package com.wishhust.interview.shangtang;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        int indexOfG = s.indexOf("G");
        if (indexOfG == -1) {
            System.out.println(0);
            return;
        }
        sb.setCharAt(indexOfG, 'a');
        int index = indexOfG+1;
        test:
        while (indexOfG < sb.length() && index < sb.length()) {
            while (sb.charAt(index) != 'o') {
                index++;
                if (index == sb.length()) {
                    break test;
                }
            }

            sb.setCharAt(index, 'a');
            while (sb.charAt(index) != 'o') {
                index++;
                if (index == sb.length()) {
                    break test;
                }
            }

            sb.setCharAt(index, 'a');
            while (sb.charAt(index) != 'd') {
                index++;
                if (index == sb.length()) {
                    break test;
                }
            }

            sb.setCharAt(index, 'a');
            count++;

            indexOfG = sb.indexOf("G");
            if (indexOfG == -1) {
                break;
            }
            sb.setCharAt(indexOfG, 'a');
            index = indexOfG+1;

        }
        System.out.println(count);
    }
}
