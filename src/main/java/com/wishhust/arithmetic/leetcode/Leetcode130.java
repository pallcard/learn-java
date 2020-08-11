package com.wishhust.arithmetic.leetcode;

public class Leetcode130 {
    public static void main(String[] args) {
        System.out.println();
    }

    public int [][] direct = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            // 第一列
            if (board[i][0] == 'O') {
                board[i][0] = 'z';
                dfs(board, i, 0);
            }
            // 最后一列
            if (board[i][board[0].length-1] == 'O') {
                board[i][board[0].length-1] = 'z';
                dfs(board, i, board[0].length-1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            // 第一行
            if (board[0][i] == 'O') {
                board[0][i] = 'z';
                dfs(board, 0,  i);
            }
            // 最后一行
            if (board[board.length-1][i] == 'O') {
                board[board.length-1][i] = 'z';
                dfs(board, board.length-1, i);
            }


        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'z') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int temp_x = x + direct[i][0];
            int temp_y = y + direct[i][1];
            if (temp_x >= 0 && temp_x < board.length && temp_y >= 0 && temp_y < board[0].length && board[temp_x][temp_y] == 'O') {
                board[temp_x][temp_y] = 'z';
                dfs(board, temp_x, temp_y);
            }
        }
    }
}
