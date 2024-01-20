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

    public boolean isValidBST_2(TreeNode root) {
        return check_2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check_2(TreeNode root, Long min, Long max) {
        if (root == null) return true;
        if (root.val <= min || max <= root.val) return false;

        if (root.left != null && root.right != null) {
            return check_2(root.left, min, (long) root.val) && check_2(root.right, (long) root.val, max) && root.left.val < root.val && root.val < root.right.val;
        } else if (root.left != null) {
            return check_2(root.left, min, (long) root.val) && root.left.val < root.val;
        } else if (root.right != null) {
            return check_2(root.right, (long) root.val, max) && root.val < root.right.val;
        } else {
            return true;
        }
    }
}
