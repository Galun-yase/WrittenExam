package LeetcodeAndOffer.Leetcode;

public class LC1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int[] preSum = new int[arr.length + 1];

        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        // i代表从哪个元素开始，j代表子数组的长度
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr.length; j += 2) {

                if (i + j - 1 < arr.length) {
                    res += preSum[i + j] - preSum[i];
                }
            }
        }
        return res;
    }
}
