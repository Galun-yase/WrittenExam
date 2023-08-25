package LeetcodeAndOffer.Leetcode;

public class LC538 {
    int sum = 0;

    public TreeNode dfs_postconvertBST(TreeNode root) {
        dfs_post(root);
        return root;
    }

    // 后置访问
    private void dfs_post(TreeNode root) {
        if (root != null) {
            dfs_post(root.right);
            sum += root.val;
            root.val = sum;
            dfs_post(root.left);
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
}
