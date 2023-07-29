package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;

public class LC560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //前缀和为0的默认有一次
        hashMap.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {

            preSum += num;
            if (hashMap.containsKey(preSum - k)) {
                count += hashMap.get(preSum - k);
            }

            hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
