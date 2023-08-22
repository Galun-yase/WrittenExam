package LeetcodeAndOffer.Leetcode;

public class LC110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    /**
     * 获取节点的高度，如果节点非平衡树则返回-1
     * LeetCode中以节点为一度，维基百科以边为一度
     */
    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left_height = getHeight(root.left);
        if (left_height == -1) return -1;

        int right_height = getHeight(root.right);
        if (right_height == -1) return -1;

        return Math.abs(left_height - right_height) < 2 ? Math.max(left_height, right_height) + 1 : -1;
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
