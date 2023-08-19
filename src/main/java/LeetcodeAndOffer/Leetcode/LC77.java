package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(n, k, 1, path, res);

        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {

            path.add(i);
            backtrack(n, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
