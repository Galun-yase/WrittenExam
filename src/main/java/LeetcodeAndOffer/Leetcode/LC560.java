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

    public int subarraySum_2(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int res = 0;

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < i; j++) {

                if (prefixSum[i] - prefixSum[j] == k) res++;
            }
        }
        return res;
    }

    public int subarraySum_3(int[] nums, int k) {
        //前缀和为key出现的次数value
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int res = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            prefixSum += num;

            if (hashMap.containsKey(prefixSum - k)) {
                res += hashMap.get(prefixSum - k);
            }

            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}
