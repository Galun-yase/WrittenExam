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

    public int eraseOverlapIntervals_2(int[][] intervals) {
        int[][] arr = Arrays.stream(intervals).sorted((a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a1[1] - a2[1];
            } else {
                return a1[0] - a2[0];
            }
        }).toArray(int[][]::new);


        int res = 0;
        int end = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            int[] ints = arr[i];

            if (ints[0] < end) {
                end = Math.min(end, ints[1]);
                res++;
            } else {
                end = ints[1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] a = {{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {
//                30, 47}, {-40, -26}};
        int[][] a = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        new LC435().eraseOverlapIntervals_2(a);


    }
}
