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

    public int maxProfit_2(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
