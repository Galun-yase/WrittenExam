package DP;

import java.util.Arrays;

public class Solution300 {

    /**
     * 给定一个无序的整数数组，找到其中最长的上升子序列的长度
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n<=1){return n;}


        int[] dp=new int[n];
        dp[0]=1;

        for (int i=1;i<n;i++){
            int temp=0;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    temp=Math.max(temp,dp[j]);
                }
            }
            dp[i]=temp+1;
        }
        Arrays.sort(dp);
        return dp[n-1];


    }
}

/**
 * 动态规划最简单类型，线性规划 一维数组解决
 * 状态转移dp[n],表示以nums[n-1]结尾的最长上升子序列
 */