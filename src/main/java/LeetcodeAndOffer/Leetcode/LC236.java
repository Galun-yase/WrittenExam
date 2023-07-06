package LeetcodeAndOffer.Leetcode;

public class LC236 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        if (root == q) return q;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;

        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor_z(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        if (isInTree(root.left, p.val) && isInTree(root.left, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (isInTree(root.right, p.val) && isInTree(root.right, q.val)) {
            return lowestCommonAncestor(root.right, p, q);

        } else {
            return root;
        }


    }

    private boolean isInTree(TreeNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        return isInTree(root.left, val) || isInTree(root.right, val);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
