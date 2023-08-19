package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 方便去重
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        backtrack(nums, used, path, res);

        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums, used, path, res);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
