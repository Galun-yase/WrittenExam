package LeetcodeAndOffer.Leetcode;

public class LC222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            int leftNodes = (1 << leftDepth) - 1;
            int rightNodes = countNodes(root.right);

            return leftNodes + rightNodes + 1;
        } else {
            int rightNodes = (1 << rightDepth) - 1;
            int leftNodes = countNodes(root.left);

            return leftNodes + rightNodes + 1;
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
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
