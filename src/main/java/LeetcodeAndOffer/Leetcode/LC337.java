package LeetcodeAndOffer.Leetcode;

public class LC337 {

    public int rob(TreeNode root) {
        int[] res = chooseNode(root);

        return Math.max(res[0], res[1]);
    }

    private int[] chooseNode(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = chooseNode(node.left);
        int[] right = chooseNode(node.right);

        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = left[0] + right[0] + node.val;
        return dp;
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
