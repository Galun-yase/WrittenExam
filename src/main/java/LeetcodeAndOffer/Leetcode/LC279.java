package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LC279 {
    public int numSquares(int n) {
        // 存储完全平方数
        ArrayList<Integer> list = new ArrayList<>();
        int index = 1;
        while (index * index <= n) {
            list.add(index * index);
            index++;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < list.size(); j++) {
                Integer squeue = list.get(j);
                if (squeue > i) break;

                dp[i] = Math.min(dp[i], dp[i - squeue] + 1);
            }
        }
        return dp[n];
    }
}
