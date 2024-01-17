package LeetcodeAndOffer.Leetcode;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<List<Integer>> subsetsWithDup_2(int[] nums) {
        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();

        backtrack(nums, 0, subset, subsets);

        return subsets;
    }

    private void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));
        if (index == nums.length) return;

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }

}
