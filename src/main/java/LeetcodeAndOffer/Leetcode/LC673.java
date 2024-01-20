package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;

public class LC673 {
    public int findNumberOfLIS(int[] nums) {
        // 以nums[i]为末尾的子序列长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        // 以nums[i]为末尾的子序列个数
        int[] dp_count = new int[nums.length];
        Arrays.fill(dp_count, 1);

        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] <= nums[j]) continue;

                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    dp_count[i] = dp_count[j];
                } else if (dp[i] == dp[j] + 1) {
                    dp_count[i] += dp_count[j];
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLength) {
                res += dp_count[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3, 5, 4, 7, 2};
        new LC673().findNumberOfLIS(a);
    }

    public int findNumberOfLIS_2(int[] nums) {
        int[] dp_sum = new int[nums.length];
        int[] dp_len = new int[nums.length];
        Arrays.fill(dp_sum, 1);
        Arrays.fill(dp_len, 1);


        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;


                if (dp_len[i] < dp_len[j] + 1) {
                    dp_len[i] = dp_len[j] + 1;

                    dp_sum[i] = dp_sum[j];
                } else if (dp_len[i] == dp_len[j] + 1) {
                    dp_sum[i] += dp_sum[j];
                }
            }
            maxLength = Math.max(maxLength, dp_len[i]);
        }

        int sum = 0;
        for (int i = 0; i < dp_sum.length; i++) {
            if (maxLength == dp_len[i]) {
                sum += dp_sum[i];
            }
        }

        return sum;
    }
}
