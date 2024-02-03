package LeetcodeAndOffer.Leetcode;

import java.util.HashSet;

public class LC1695 {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int res = 0;
        int sum = 0;

        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            while (hashSet.contains(nums[end])) {
                sum -= nums[start];
                hashSet.remove(nums[start]);
                start++;
            }

            sum += nums[end];
            hashSet.add(nums[end]);
            res = Math.max(res, sum);
        }
        return res;
    }

    public int maximumUniqueSubarray_2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int start = 0;
        int sum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {

            while (hashSet.contains(nums[i])) {
                hashSet.remove(nums[start]);
                sum -= nums[start];
                start++;
            }

            hashSet.add(nums[i]);
            sum += nums[i];

            res = Math.max(res, sum);
        }
        return res;
    }
}
