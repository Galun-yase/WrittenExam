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

    int value = 0;

    public TreeNode convertBST_2(TreeNode root) {
        convertBST_dfs(root);
        return root;
    }

    private void convertBST_dfs(TreeNode root) {
        if (root != null) {
            convertBST_dfs(root.right);
            value += root.val;
            root.val = value;
            convertBST_dfs(root.left);
        }
    }
}
