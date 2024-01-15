package LeetcodeAndOffer.Leetcode;

import java.util.*;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {

            if (res.size() == 0) {
                res.add(intervals[i]);
                continue;
            }

            int[] interval = intervals[i];
            int left = interval[0];
            int right = interval[1];

            int[] last = res.get(res.size() - 1);
            if (left <= last[1]) {
                int newRight = Math.max(right, last[1]);
                last[1] = newRight;
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge_2(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a1, a2) -> {
            if (a1[0] != a2[0]) {
                return a1[0] - a2[0];
            } else {
                return a1[1] - a2[1];
            }
        });


        LinkedList<int[]> linkedList = new LinkedList<>();
        linkedList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = linkedList.getLast();

            int[] next = intervals[i];

            if (last[1] >= next[0]) {
                last[1] = Math.max(last[1], next[1]);
            } else {
                linkedList.add(next);
            }
        }

        return linkedList.toArray(new int[0][]);

    }
}
