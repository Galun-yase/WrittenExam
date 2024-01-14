package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3) return res;
        int length = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) break;

            // 去重
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum_2(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int res = nums[i] + nums[left] + nums[right];

                if (res == 0) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    list.add(l);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                } else if (res < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return list;
    }
}
