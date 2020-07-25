package com.wishhust.arithmetic.leetcode;

/**
 * 除数博弈
 * 开始N，每次玩家选一个数字x
 *  （1）x 满足 0 < x < N 且 N % x == 0
 *  （2）N-x替换 N
 *  无法操作时，玩家输掉
 *
 *
 *  分析：
 *  1。当N=1时玩家输掉
 *  2。当N>1时
 *  若N为偶数，玩家可以使对方拿到 奇数/偶数   《= 偶数当约数 奇数/偶数
 *  若N为奇数，玩家只能使对方拿到 偶数       《= 奇数的约数  奇数
 *
 *  故当玩家拿到偶数之后，一直让对方拿奇数，则可以保证最终对方拿到1，从而赢得比赛
 *
 */
public class Leetcode1025 {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode1025().divisorGame(2));
    }
}
