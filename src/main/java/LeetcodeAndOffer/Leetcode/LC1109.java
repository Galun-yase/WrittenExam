package LeetcodeAndOffer.Leetcode;

public class LC1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 使用差分数组，解决i-j之前都增加的问题
        int[] res = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];

            int first = booking[0];
            int last = booking[1];
            int value = booking[2];

            res[first - 1] += value;
            if (last < n) {
                res[last] -= value;
            }
        }

        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
