package LeetCode;

public class Solution17_16 {


    //二维状态变量，化解约束
    public int massage(int[] nums) {
        int n=nums.length;
        if (n==0){
            return 0;
        }else if (n==1){
            return nums[0];
        }

        int[][] dp=new int[n][2];

        //dp[i][0]表示第i天不接受，[0,i]最长时间
        //dp[i][1]表示第i天接受，[0,i]最长时间
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);


    }


    //一维状态变量
    public int massage2(int[] nums) {
        int n=nums.length;
        if (n==0){
            return 0;
        }else if (n==1){
            return nums[0];
        }

        int[] dp=new int[n];

        //初始化
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i <n ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];


    }


}
