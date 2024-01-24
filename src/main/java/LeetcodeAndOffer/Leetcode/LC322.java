package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    // 完全背包解法
    public int coinChange_second(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] = amount + 1;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {

                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 完全背包，此处dp[i][j - coins[i - 1]] + 1不用dp[i-1]，可以拿多次
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];
    }


    public int coinChange_2(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0) return 0;
        if (coins[0] > amount) return -1;
        Set<Integer> set = Arrays.stream(coins).boxed().collect(Collectors.toSet());
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < amount + 1; i++) {
            if (set.contains(i)) {
                dp[i] = 1;
            }
        }
        dp[0] = 0;

        for (int i = coins[0] + 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i > coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {

                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);

                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
