package LeetcodeAndOffer.Leetcode;

public class LC174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // dp[i][j]代表到达时需要的最小健康点数
        int[][] dp = new int[m][n];
        // dp[i][j]最小值不能小于1,留够下一个节点的就行
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] - dungeon[m - 1][i]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j] - dungeon[i][j], dp[i][j + 1] - dungeon[i][j]);

                dp[i][j] = Math.max(1, min);
            }
        }
        return dp[0][0];
    }

    public int calculateMinimumHP_2(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i + 1 < m && j + 1 < n) {
                    dp[i][j] = Math.min(dp[i + 1][j] - dungeon[i][j], dp[i][j + 1] - dungeon[i][j]);
                } else if (i + 1 < m) {
                    dp[i][j] = dp[i + 1][j] - dungeon[i][j];
                } else if (j + 1 < n) {
                    dp[i][j] = dp[i][j + 1] - dungeon[i][j];
                } else {
                    int num = dungeon[i][j];

                    if (num >= 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 - num;
                    }
                }

                dp[i][j] = Math.max(1, dp[i][j]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dp = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};

        new LC174().calculateMinimumHP_2(dp);

    }
}
