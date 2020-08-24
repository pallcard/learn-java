package com.wishhust.interview.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] wight = new int[n];
        int [] index = new int[n];
        int [] res = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        int resIndex = n-1;
        for (int i = 0; i < n; i++) {
            wight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            index[i] = sc.nextInt()-1;
        }
        res[resIndex--] = 0;
        int max = 0;

        for (int i = index.length-1; i > 0; i--) {
            int v = 0;
            if (map.containsKey(index[i]-1) && map.containsKey(index[i]+1)) {
                v = map.get(index[i]-1) + map.get(index[i]+1) + wight[index[i]];
                int dex = 1;
                while (map.containsKey(index[i]-dex)) {
                    map.put(index[i]-dex, v);
                    dex--;
                }
                map.put(index[i], v);
                dex = 1;
                while (map.containsKey(index[i]+dex)) {
                    map.put(index[i]+dex, v);
                    dex++;
                }

            } else if(map.containsKey(index[i]-1)) {
                v = map.get(index[i]-1) + wight[index[i]];
                int dex = 1;
                while (map.containsKey(index[i]-dex)) {
                    map.put(index[i]-dex, v);
                    dex--;
                }
                map.put(index[i], v);
            } else if (map.containsKey(index[i]+1)) {
                v = map.get(index[i]-1) + wight[index[i]];
                map.put(index[i], v);
                int dex = 1;
                while (map.containsKey(index[i]+dex)) {
                    map.put(index[i]+dex, v);
                    dex++;
                }
            } else {
                v = wight[index[i]];
                map.put(index[i], v);
            }
            max = Math.max(max, v);
            res[resIndex--] = max;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }


    }
}
