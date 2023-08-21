package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;

public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            insertNode(root, node, hashMap);
        }
        return root;
    }

    private void insertNode(TreeNode root, TreeNode node, HashMap<Integer, Integer> hashMap) {
        while (root != node) {

            if (hashMap.get(node.val) < hashMap.get(root.val)) {
                if (root.left == null) {
                    root.left = node;
                }
                root = root.left;

            } else {
                if (root.right == null) {
                    root.right = node;
                }
                root = root.right;
            }
        }
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
