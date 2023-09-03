package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;

public class LC322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];

                if (coin > i) continue;
                // 如果dp[i - coin] == -1，代表此coin不能组成
                if (dp[i - coin] == -1) continue;

                if (dp[i] == -1 || dp[i] > dp[i - coin] + 1) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }
        return dp[amount];
    }
}
