package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;
import java.util.Map;

public class LC213 {
    public int myRob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[length];
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] first = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] end = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(myRob(first), myRob(end));
    }
}
