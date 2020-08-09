package com.wishhust.interview.netease;

import java.util.*;
import java.util.stream.IntStream;

public class Test04 {

    public static Set<Integer> visited = new HashSet<>();
    public static int res = 0;
    public static boolean flag = true;
    public static void main(String[] args) {

        Random random = new Random(1);
        int s = random.nextInt();
        System.out.println(s);

//        Scanner scanner = new Scanner(System.in);
//
//        int N = scanner.nextInt();
//        int M = scanner.nextInt();
//
//        int[][] graph = new int[N+1][N+1];
//
//
//        for (int i = 0; i < M; i++) {
//            int start = scanner.nextInt();
//            int end = scanner.nextInt();
//            graph[start][end] = 1;
//        }
//
//        List<Integer> init = new ArrayList<>();
//
//        for (int i = 1; i <= N; i++) {
//            init.add(i);
//        }
//
//
//        while (init.size() > 0) {
//            Integer remove = init.get(0);
//            dfs(graph, remove);
//            init.removeAll(visited);
//            visited.clear();
//            flag = true;
//        }
//        System.out.println(res);
    }

    public static int count(int n) {
        if (n < 2) {
            return 0;
        }
        return n*(n-1)/2;
    }

    public static void dfs(int[][] graph, int nums) {
        if (visited.contains(nums)) {
            res += count(nums);
            return;
        }
        visited.add(nums);

        for (int i = 1; i < graph.length; i++) {
            if (graph[nums][i] == 1) {
                if (visited.contains(i)) {
                    res += count(nums);
                    flag = false;
                    return;
                }
                dfs(graph, i);
                if (!flag) {
                    return;
                }
            }
        }
    }
}
