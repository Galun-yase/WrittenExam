package LeetcodeAndOffer.Leetcode;

public class LC69 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public int mySqrt_2(int x) {
        int res = 0;

        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
