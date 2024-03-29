package LeetcodeAndOffer.Leetcode;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
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

    public TreeNode invertTree_2(TreeNode root) {
        if (root == null) return root;

        TreeNode left = invertTree_2(root.left);
        TreeNode right = invertTree_2(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

}
