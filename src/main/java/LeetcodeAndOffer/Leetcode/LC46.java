package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        backtrack(nums, path, used, res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums, path, used, res);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


    public List<List<Integer>> permute_2(int[] nums) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();

        boolean[] used = new boolean[nums.length];
        backtrack_2(nums, used, path, res);
        return res;
    }

    private void backtrack_2(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;

            path.add(nums[i]);
            used[i] = true;

            backtrack_2(nums, used, path, res);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
