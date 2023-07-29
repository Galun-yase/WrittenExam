package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;

public class LC1248 {
    public int numberOfSubarrays(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int count = 0;
        int preSum = 0;

        for (int num : nums) {
            if (num % 2 == 1) preSum += 1;

            if (hashMap.containsKey(preSum - k)) {
                count += hashMap.get(preSum - k);
            }
            hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
