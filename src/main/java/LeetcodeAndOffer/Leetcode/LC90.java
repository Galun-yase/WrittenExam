package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(0, nums, subset, subsets);
        return subsets;
    }

    private void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));

        if (i >= nums.length) return;

        for (int j = i; j < nums.length; j++) {
            // 去重
            if (j > i && nums[j] == nums[j - 1]) continue;

            subset.add(nums[j]);
            backtrack(j + 1, nums, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }
}
