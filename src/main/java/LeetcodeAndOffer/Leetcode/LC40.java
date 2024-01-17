package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

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

            if (i > 0 && i > start && candidates[i - 1] == candidates[i]) continue;

            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack_2(candidates, 0, target, path, res);

        return res;
    }

    private void backtrack_2(int[] candidates, int index, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (candidates.length == index) return;

        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];

            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidate > target) break;

            path.add(candidate);
            backtrack_2(candidates, i + 1, target - candidate, path, res);
            path.remove(path.size() - 1);
        }
    }

}
