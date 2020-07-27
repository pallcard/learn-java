package com.wishhust.arithmetic.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode329 {

    public static int[][] direct = new int[][] {
            {0, 1}, {0, 1}, {0, -1}, {-1, 0}
    };

    public static int max = -1;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length ==0) {
            return 0;
        }
        int [][] visited = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j] == 1) {
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                list.add(matrix[i][j]);
                dfs(matrix, visited, i, j, list);
            }
        }
        return max;
    }

    public void dfs(int[][] matrix, int[][] visited, int x, int y, List<Integer> list) {
        for (int i = 0; i < direct.length; i++) {
            int tempX = x + direct[i][0];
            int tempY = y + direct[i][1];
            if (tempX >= 0 && tempX < matrix.length && tempY >= 0 && tempY < matrix[0].length && matrix[tempX][tempY] > matrix[x][y]) {
                list.add(matrix[tempX][tempY]);
                visited[tempX][tempY] = 1;
                dfs(matrix, visited, tempX, tempY, list);
            }
        }
        max = Math.max(max, list.size());
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode329().longestIncreasingPath(new int[][]{
//                {9,9,4},{6,6,8},{2,1,1}
                {1}
        }));
    }

}
