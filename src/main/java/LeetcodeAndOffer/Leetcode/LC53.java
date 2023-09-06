package LeetcodeAndOffer.Leetcode;

public class LC53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int maxLength = dp[0];
        for (int i = 1; i < nums.length; i++) {

            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}