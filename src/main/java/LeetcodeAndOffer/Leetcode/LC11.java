package LeetcodeAndOffer.Leetcode;

import javafx.util.Pair;

import java.util.Map;
import java.util.Stack;

public class LC11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int res = 0;

        while (left < right) {
            int d = right - left;
            int h = Math.min(height[left], height[right]);
            int area = d * h;

            res = Math.max(res, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public int maxArea_2(int[] height) {

        int start = 0;
        int end = height.length - 1;

        int res = 0;
        while (start < end) {
            res = Math.max(res, (end - start) * Math.min(height[start], height[end]));

            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}
