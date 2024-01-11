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

    public int[] twoSum_second(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            Integer index = hashMap.get(key);

            //注意同一个坐标不能出现两次，但是可以出现不同坐标的相同数字
            if (index != null && index != i) {
                return new int[]{i, index};
            }
        }
        return null;
    }

    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }

            hashMap.put(nums[i], i);
        }
        return null;
    }
}
