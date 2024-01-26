package LeetcodeAndOffer.Leetcode;

public class LC1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        // 尽可能靠近一半
        int bagSize = sum / 2;

        int[][] dp = new int[stones.length + 1][bagSize + 1];

        for (int i = 1; i < stones.length + 1; i++) {
            for (int j = 1; j < bagSize + 1; j++) {

                if (j < stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }

        return Math.abs(sum - dp[stones.length][bagSize] - dp[stones.length][bagSize]);
    }

    public int lastStoneWeightII_2(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int bagSize = sum / 2;

        boolean[][] dp = new boolean[stones.length + 1][bagSize + 1];
        for (int i = 0; i < stones.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < stones.length + 1; i++) {
            for (int j = 1; j < bagSize + 1; j++) {

                if (j < stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j];

                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                }
            }
        }

        int b = 0;
        for (int i = bagSize; i >= 0; i--) {
            if (dp[stones.length][i]) {
                b = i;
                break;
            }
        }

        return sum - b - b;
    }
}
