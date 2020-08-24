package com.wishhust.interview.cvte;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        int[][] arr = helixArray(5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

    }

    public static int[][] helixArray(int N) {
        int [][] arr = new int[N][N];
        int n = 1;
        int i = 0;

        while (n<=N*N) {
            int j = 0;
            while (j < N) {
                arr[i][j++] = n++;
            }
            i++;
            if (n>N*N) {
                break;
            }
            j--;
            while (j >= 0) {
                arr[i][j--] = n++;
            }
            i++;
        }
        return arr;
    }
}
