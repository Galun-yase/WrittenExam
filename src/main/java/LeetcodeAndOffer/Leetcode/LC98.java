package LeetcodeAndOffer.Leetcode;

public class LC98 {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;

        if (root.val < minValue || root.val > maxValue) return false;
        // 要用long保存一下，否则会溢出
        long val = root.val;

        return check(root.left, minValue, val - 1) && check(root.right, val + 1, maxValue);

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
