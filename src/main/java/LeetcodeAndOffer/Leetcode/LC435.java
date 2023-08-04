package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));

        int end = intervals[0][1];
        int res = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] >= end) {
                end = interval[1];
            } else {
                end = Math.min(end, interval[1]);
                res++;
            }
        }
        return res;
    }
}
