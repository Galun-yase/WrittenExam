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
}
