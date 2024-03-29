package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4) return res;

        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long)nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) continue;

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) continue;

                if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long)nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) continue;

                int left = j + 1;
                int right = length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }
            }
        }
        return res;
    }
}
