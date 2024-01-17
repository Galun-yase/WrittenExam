package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(0, nums, subset, subsets);
        return subsets;
    }

    private void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
        // 注意一定要深拷贝过去
        subsets.add(new ArrayList<>(subset));

        if (i >= nums.length) return;

        for (int j = i; j < nums.length; j++) {
            subset.add(nums[j]);

            backtrack(j + 1, nums, subset, subsets);

            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsets_2(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(nums, 0, subset, subsets);
        return subsets;
    }

    void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));
        if (index == nums.length) return;

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }


}
