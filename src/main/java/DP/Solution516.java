package DP;

public class Solution516 {
    /**
     *给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
     *
     * 输入："bbbab"
     * 输出：4   bbbb
     *
     */

    public int longestPalindromeSubseq(String s) {

        int n=s.length();
        int[][] dp=new int[n][n];


        for (int i =n-1; i >=0 ; i--) {
            dp[i][i]=1;
            for (int j = i+1; j <n ; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                }

            }
        }
        return dp[0][n-1];

    }


}

/**
 * dp[i][j]表示i与j最长的回文字序列  区间规划
 */
