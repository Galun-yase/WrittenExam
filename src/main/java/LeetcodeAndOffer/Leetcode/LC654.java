package LeetcodeAndOffer.Leetcode;

public class LC654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);

        int maxNumIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[maxNumIndex] < nums[i]) {
                maxNumIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxNumIndex]);

        root.left = construct(nums, left, maxNumIndex - 1);
        root.right = construct(nums, maxNumIndex + 1, right);
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

    public TreeNode constructMaximumBinaryTree_2(int[] nums) {
        return construct_2(nums, 0, nums.length - 1);
    }

    private TreeNode construct_2(int[] nums, int left, int right) {
        if (left > right) return null;

        int res = -1;
        for (int i = left; i <= right; i++) {
            res = Math.max(res, nums[i]);
        }

        int index = -1;
        for (int i = left; i <= right; i++) {
            if (res == nums[i]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(res);
        TreeNode leftNode = construct_2(nums, left, index - 1);
        TreeNode rightNode = construct_2(nums, index + 1, right);

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }

    public static void main(String[] args) {
        int[] n = {3, 2, 1, 6, 0, 5};
        new LC654().constructMaximumBinaryTree_2(n);
    }
}
