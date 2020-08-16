package com.wishhust.arithmetic.leetcode;

public class Leetcode733 {
    public int [][] dire = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        if (originColor == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        dfs(image, sr, sc, newColor, originColor);
        return image;
    }

    public void dfs(int[][] image, int x, int y, int newColor, int originColor) {

        for (int i = 0; i < 4; i++) {
            int nextX = x + dire[i][0];
            int nextY = y + dire[i][1];
            if (nextX >= 0 && nextX < image.length && nextY >= 0 && nextY < image[0].length && image[nextX][nextY] == originColor) {
                image[nextX][nextY] = newColor;
                dfs(image, nextX, nextY, newColor, originColor);
            }
        }
    }
}
