package LeetcodeAndOffer.Leetcode;

public class LC278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            // 这种处理不容易产生溢出
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean isBadVersion(int n) {
        return false;
    }

    public int firstBadVersion_2(int n) {

        int left = 1;
        int right = n;
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
