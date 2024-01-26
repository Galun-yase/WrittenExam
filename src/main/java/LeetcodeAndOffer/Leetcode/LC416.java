package LeetcodeAndOffer.Leetcode;

public class LC416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) return false;

        int bagSize = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][bagSize + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < bagSize + 1; j++) {

                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][bagSize];
    }

    public boolean canPartition_2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {

                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
