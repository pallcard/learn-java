package com.wishhust.interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Demo12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] price = new int[n][2];
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            price[i][0] = v+2*w;
            price[i][1] = i;
        }

        Arrays.sort(price, (a,b)->b[0]-a[0]);


        int [] res = new int[m];
        for (int i = 0; i < m; i++) {
            res [i] = price[i][1]+1;
        }
        Arrays.sort(res);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(res[i]+" ");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
