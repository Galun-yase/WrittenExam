package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;
import java.util.Map;

public class LC334 {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
            if (maxLength >= 3) return true;
        }
        return false;
    }

    // 贪心 first与second尽可能小
    public boolean increasingTriplet_second(int[] nums) {
        if (nums.length < 3) return false;

        int first = nums[0];
        int second = Integer.MAX_VALUE;

        for (int third : nums) {
            if (third > second) {
                return true;
            } else if (third > first) {
                second = third;
            } else {
                first = third;
            }
        }
        return false;
    }

    public boolean increasingTriplet_3(int[] nums) {
        if (nums.length < 3) return false;

        int first = nums[0];
        int second = Integer.MAX_VALUE;

        for (int third : nums) {
            if (third > second) {
                return true;
            } else if (third > first) {
                second = third;
            } else {
                first = third;
            }
        }
        return false;
    }
}
