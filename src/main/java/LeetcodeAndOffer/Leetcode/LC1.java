package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int d = target - nums[i];
            if (hashMap.get(d) != null) return new int[]{hashMap.get(d), i};

            hashMap.put(nums[i], i);
        }
        return null;
    }
}
