package LeetcodeAndOffer.Leetcode;

public class LC198 {
    public int rob(int[] nums) {
        int length = nums.length;

        // dp[i]前i个房间能偷取的最大值
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[length];
    }
}
