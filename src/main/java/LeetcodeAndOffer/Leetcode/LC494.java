package LeetcodeAndOffer.Leetcode;

public class LC494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 不可能凑出为小数的背包
        if ((sum + target) % 2 == 1) return 0;
        // target过大不能凑出
        if ( target < 0 && sum < -target) return 0;
        if ( target > 0 && sum < target) return 0;

        int bagSize = (sum + target) / 2;
        if (bagSize < 0) bagSize = -bagSize;

        // dp[i][j] 代表前i个数字凑出j的方案个数
        int[][] dp = new int[nums.length + 1][bagSize + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            // 当前元素nums[i - 1]可能为0，所有凑成j=0的背包也是可能的
            for (int j = 0; j < bagSize + 1; j++) {

                // 超过背包大小，不选择
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                // 当前元素可以选择，也可以不选择，故求方案总数
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][bagSize];
    }
}
