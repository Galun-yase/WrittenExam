package LeetcodeAndOffer.Leetcode;

import java.util.List;

public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();

        int[] dp = new int[size + 1];

        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
