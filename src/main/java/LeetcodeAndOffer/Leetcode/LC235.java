package LeetcodeAndOffer.Leetcode;

public class LC235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while ((long) (root.val - p.val) * (long) (root.val - q.val) > 0) {
            if (root.val > p.val) {
                root = root.left;
            } else {
                root = root.right;
            }

        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p) return p;
        if (root == q) return q;

        if (p.val < root.val && root.val < q.val) {
            return root;
        }

        if (q.val < root.val && root.val < p.val) {
            return root;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor_2(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor_2(root.right, p, q);
        }

        return null;
    }
}
