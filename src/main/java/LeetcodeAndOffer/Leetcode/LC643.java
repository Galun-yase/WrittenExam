package LeetcodeAndOffer.Leetcode;

public class LC643 {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double largest = Integer.MIN_VALUE;

        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            if (end - start + 1 == k) {
                largest = Math.max(largest, sum / k);
                sum -= nums[start];
                start++;
            }
        }
        return largest;
    }

    public double findMaxAverage_2(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double res = sum / k;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];

            res = Math.max(res, sum / k);
        }
        return res;
    }
}
