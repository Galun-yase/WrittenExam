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

    public int numberOfSubarrays_2(int[] nums, int k) {
        // 前缀奇数个数为key的出现的次数value
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int res = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num % 2 != 0) {
                prefixSum++;
            }

            if (hashMap.containsKey(prefixSum - k)) {
                res += hashMap.get(prefixSum - k);
            }

            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,2,2,1,2,2,1,2,2,2};

        new LC1248().numberOfSubarrays_2(a,2);
    }
}
