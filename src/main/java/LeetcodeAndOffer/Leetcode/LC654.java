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
}
