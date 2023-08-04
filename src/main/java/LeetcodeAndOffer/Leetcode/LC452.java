package LeetcodeAndOffer.Leetcode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class LC452 {
    public int findMinArrowShots_right(int[][] points) {
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int pos = points[0][1];
        int res = 1;

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];

            if (point[0] > pos) {
                pos = point[1];
                res++;
            }
        }
        return res;
    }

    public int findMinArrowShots_left(int[][] points) {
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int pos = points[0][1];
        int res = 1;

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];

            if (point[1] < pos) {
                pos = point[1];

            } else if (point[0] > pos) {
                pos = point[1];
                res++;
            }
        }
        return res;
    }
}
