package com.wishhust.interview.dajiang;

import java.util.Scanner;

//4 5
//        0 1 15
//        1 2 15
//        0 3 50
//        1 3 50
//        2 3 10
//        3
public class Test1 {
    public static void main(String[] args) {

        int k,i,j;

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] map = new int[N][N];

        //初始化
        for(i=0; i<N; i++)
            for(j=0; j<N; j++)
                if(i==j)
                    map[i][j]=0;
                else
                    map[i][j]=Integer.MAX_VALUE;

        for (int l = 0; l < M; l++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int v = scanner.nextInt();
            map[x][y] = v;
        }
        int target = scanner.nextInt();

        //Floyd-Warshall算法核心语句
        for(k=0; k<N; k++)
            for(i=0; i<N; i++)
                for(j=0; j<N; j++)
                    if(map[i][k]+map[k][j]>0 && map[i][j]>map[i][k]+map[k][j] )
                        map[i][j]=map[i][k]+map[k][j];

        System.out.println(map[0][target]);

    }
}
