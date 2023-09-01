package LeetcodeAndOffer.Leetcode;

public class LC123 {
    public int maxProfit(int[] prices) {
        int k = 2;
        if (prices == null || prices.length == 0 || k < 1) return 0;

        int length = prices.length;

        int[][][] dp = new int[length][k + 1][2];
        for (int i = 1; i <= k; i++) {
            // i=0时不交易，故收益为0
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < k + 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);

                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[length - 1][k][0];
    }
}
