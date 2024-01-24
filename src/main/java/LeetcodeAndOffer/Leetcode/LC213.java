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

    public int rob_2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int length = nums.length;

        int[] first = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] end = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(myRob_2(first), myRob(end));
    }

    public int myRob_2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(dp[0], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[nums.length - 1];
    }

}
