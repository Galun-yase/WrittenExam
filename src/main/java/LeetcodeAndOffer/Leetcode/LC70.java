package LeetcodeAndOffer.Leetcode;

public class LC70 {
    // 超出时间限制，未剪枝
    public int climbStairs_digui(int n) {
        if (n <= 1) return n;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //动态规划，存储状态
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int i = new LC70().climbStairs(45);
        System.out.println(i);
        System.out.println(1836311903);
    }

    public int climbStairs_second(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs_3(int n) {
        if (n <= 1) return n;

        int[] ints = new int[n + 1];
        ints[1] = 1;
        ints[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }
}
