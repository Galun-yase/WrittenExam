package LeetcodeAndOffer.Leetcode;

public class LC367 {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long j = (long) mid * mid;

            if (j == num) {
                return true;
            } else if (j > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
