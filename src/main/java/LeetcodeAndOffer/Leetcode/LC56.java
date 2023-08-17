package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
}
