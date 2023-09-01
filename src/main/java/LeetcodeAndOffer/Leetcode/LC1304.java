package LeetcodeAndOffer.Leetcode;

public class LC1304 {
    public int maxProfit(int[] prices, int fee) {
        // int k = 无穷;
        if (prices == null || prices.length == 0) return 0;

        int length = prices.length;

        int[][] dp = new int[length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[length - 1][0];
    }
}
