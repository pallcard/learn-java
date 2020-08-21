package com.wishhust.arithmetic.leetcode;

public class Leetcode529 {

    public char[][] updateBoard(char[][] board, int[] click) {
        int [][] countM = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'M') {
                    if (isValid(i-1,j-1, board)){
                        countM[i-1][j-1]++;
                    }
                    if (isValid(i-1,j, board)){
                        countM[i-1][j]++;
                    }
                    if (isValid(i-1,j+1, board)){
                        countM[i-1][j+1]++;
                    }
                    if (isValid(i,j-1, board)){
                        countM[i][j-1]++;
                    }
                    if (isValid(i,j+1, board)){
                        countM[i][j+1]++;
                    }
                    if (isValid(i+1,j-1, board)){
                        countM[i+1][j-1]++;
                    }
                    if (isValid(i+1,j, board)){
                        countM[i+1][j]++;
                    }
                    if (isValid(i+1,j+1, board)){
                        countM[i+1][j+1]++;
                    }

                }
            }
        }
        int pointX = click[0];
        int pointY = click[1];
        if (board[pointX][pointY] == 'M') {
            board[pointX][pointY] = 'X';
            return board;
        }
        if (countM[pointX][pointY] > 0) {
            board[pointX][pointY] = (char) ('0' + countM[pointX][pointY]);
            return board;
        }

        dfs(pointX, pointY, board, countM);
        return board;
    }

    public int[][] dire = new int[][]{
            {1,-1},{1, 0},{1,1},{0, 1}, {0, -1}, {-1, -1}, {-1, 0},{-1, 1}
    };

    public void dfs(int x, int y, char [][] board, int [][] countM) {
        board[x][y] = 'B';
        for (int i = 0; i < 8; i++) {
            int nextX = x + dire[i][0];
            int nextY = y + dire[i][1];
            if (isValid(nextX, nextY, board) && board[nextX][nextY] == 'E') {
                if (countM[nextX][nextY] <= 0) {
                    dfs(nextX, nextY, board, countM);
                } else {
                    board[nextX][nextY] = (char) ('0' + countM[nextX][nextY]);
                }

            }

        }
    }

    public boolean isValid(int x, int y, char [][] board) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
            return true;
        }
        return false;
    }
}
