package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;

public class LC530 {

    int min = Integer.MAX_VALUE;
    ArrayList<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, Math.abs(list.get(i) - list.get(i - 1)));
        }

        return min;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    ArrayList<Integer> midList = new ArrayList<>();

    public int getMinimumDifference_2(TreeNode root) {
        int min = Integer.MAX_VALUE;
        dfs_2(root);

        for (int i = 1; i < midList.size(); i++) {
            min = Math.min(Math.abs(midList.get(i - 1) - midList.get(i)), min);
        }
        return min;
    }

    private void dfs_2(TreeNode root) {
        if (root != null) {
            dfs_2(root.left);
            midList.add(root.val);
            dfs_2(root.right);
        }
    }

}
