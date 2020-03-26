package DP;

public class Solution198 {

    /**
     *你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     *输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     */
    public int rob(int[] nums) {

        int n=nums.length;
        if (n==0){return 0;}
        if (n==1){return nums[0];}

        int[] dp=new int[n];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],nums[0]);

        for (int i = 2; i < n; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
/**
 * 状态转移条件dp[i]为dp[i-1],dp[i-2]+nums[i]中较大的一个
 */