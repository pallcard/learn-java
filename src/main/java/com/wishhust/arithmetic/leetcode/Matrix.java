package com.wishhust.arithmetic.leetcode;

public class Matrix {

    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用1表示墙
        // 上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板，1表示
        map[3][1] = 1;
        map[3][2] = 1;

        // 输出地图
        System.out.println("地图的情况");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("_______");

        System.out.println(setWay(map, 1, 1));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    // 1. map 表示地图
    // 2. i,j 表示从地图的哪个位置开始出发(1,1)
    // 3. 如果小球能到map[6][5]位置，说明通路能够找到
    // 4. 约定：当map[i][j]为0，表示该点没有走过，当为1表示墙，2表示通路可以走; 3. 表示该点已经走过，但走不通
    // 5. 在走迷宫时，需要确定一个策略(方法)，下->右->上->左，如果该点走不通，则需要回溯
    // map 表示地图 i j 表示从哪个位置开始找
    // 如果找到通路，就返回true, 否则返回false;
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 通路已经找到ok
            return true;
        }
        if (map[i][j] == 0) {

            map[i][j] = 2;

            if (setWay(map, i + 1, j)) { // 向下走

                return true;

            } else if (setWay(map, i, j + 1)) {
                // 向右走

                return true;

            } else if (setWay(map, i - 1, j)) {
                // 向上走
                return true;

            } else if (setWay(map, i, j - 1)) {
                // 向左走

                return true;
            }
            map[i][j] = 0;

        }
        return false;

    }
}