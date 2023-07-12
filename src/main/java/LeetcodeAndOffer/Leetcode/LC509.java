package LeetcodeAndOffer.Leetcode;

public class LC509 {
    public int fib(int n) {
        int[] dp = new int[n + 2];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    // 未剪枝，时间复杂度高
    public int fib_recursion(int n) {
        if (n <= 1) return n;
        return fib(n-1)+fib(n-2);
    }

}
