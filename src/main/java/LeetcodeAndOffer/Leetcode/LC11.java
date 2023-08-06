package LeetcodeAndOffer.Leetcode;

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
}
