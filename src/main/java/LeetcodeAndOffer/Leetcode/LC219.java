package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;

public class LC219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer index = hashMap.get(num);
            if (index != null && Math.abs(i - index) <= k) return true;

            hashMap.put(num, i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate_2(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashMap.containsKey(num) && i - hashMap.get(num) <= k) {
                return true;
            }

            hashMap.put(num, i);

        }
        return false;
    }
}
