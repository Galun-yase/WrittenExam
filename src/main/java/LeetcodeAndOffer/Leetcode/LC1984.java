package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;

public class LC1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int res = nums[k - 1] - nums[0];

        for (int i = k; i < nums.length; i++) {
            res = Math.min(res, nums[i] - nums[i - k + 1]);
        }
        return res;
    }

    public int minimumDifference_2(int[] nums, int k) {
        Arrays.sort(nums);

        int res = 10000001;

        for (int i = k - 1; i < nums.length; i++) {
            res = Math.min(res, nums[i] - nums[i - k + 1]);
        }
        return res;
    }
}
