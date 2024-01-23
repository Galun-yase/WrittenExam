package LeetcodeAndOffer.Leetcode;

public class LC343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public int integerBreak_2(int n) {
        if (n <= 3) return n - 1;
        int[] dp = new int[n + 1];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new LC343().integerBreak_2(10);

    }
}
