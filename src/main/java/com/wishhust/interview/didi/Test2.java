package com.wishhust.interview.didi;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        String str1 = s1.replaceAll(" ", "");
        Set<Character> pre = new HashSet<>();
        Set<Character> last = new HashSet<>();
        int indexOf = str1.indexOf("X");
        for (int i = 0; i < indexOf; i++) {
            pre.add(str1.charAt(i));
        }
        for (int i = indexOf+1; i < str1.length(); i++) {
            last.add(str1.charAt(i));
        }
        String str2 = s2.replaceAll(" ", "");
        int indexOf2 = str2.indexOf("X");
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < indexOf2; i++) {
            if (pre.contains(str2.charAt(i))) {
                count1++;
            }
        }
        for (int i = indexOf2+1; i < str2.length(); i++) {
            if (last.contains(str2.charAt(i))) {
                count2++;
            }
        }

        System.out.println((count1+1) + " " +(N-count2));

    }
}
