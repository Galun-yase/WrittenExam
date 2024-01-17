package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(candidates, target, 0, path, res);

        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, res);
            path.remove(path.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum_2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        backtrack_2(candidates, 0, target, path, res);
        return res;
    }

    private void backtrack_2(int[] nums, int index, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (nums.length == index) return;

        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) continue;

            path.add(nums[i]);
            backtrack_2(nums, i, target - nums[i], path, res);
            path.remove(path.size() - 1);
        }
    }

}
