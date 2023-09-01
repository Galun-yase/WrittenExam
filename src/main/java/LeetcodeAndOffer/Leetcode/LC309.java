package LeetcodeAndOffer.Leetcode;

public class LC309 {
    public int maxProfit(int[] prices) {
        // int k = 无穷;
        if (prices == null || prices.length <= 1) return 0;

        int length = prices.length;

        int[][] dp = new int[length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], (i == 1 ? 0 : dp[i - 2][0]) - prices[i]);
        }
        return dp[length - 1][0];
    }
}
