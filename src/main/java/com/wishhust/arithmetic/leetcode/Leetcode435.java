package com.wishhust.arithmetic.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 0) {
            return 0;
        }
        // 不重叠区间数
        int count = 1;
        // 按照end排序
        Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));

        int x_end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 当区间i的start >= x_end时 说明改区间与上一个区间不重叠
            // count++，并更新x_end
            if (intervals[i][0] >= x_end) {
                count++;
                x_end = intervals[i][1];
            }
        }
        return intervals.length-count;
    }


}
