package LeetcodeAndOffer.Leetcode;

public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {

            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode node = findMinRight(root.right);
            root.val = node.val;

            // 删除掉最小值后，还需要重新链接一下
            root.right = deleteNode(root.right, node.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode findMinRight(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
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

    public TreeNode deleteNode_2(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode max = getMax(root.left);
            root.val = max.val;

            root.left = deleteNode_2(root.left, max.val);
        } else if (root.val < key) {
            root.right = deleteNode_2(root.right, key);
        } else {
            root.left = deleteNode_2(root.left, key);
        }
        return root;
    }

    private TreeNode getMax(TreeNode root) {
        if (root.right == null) return root;
        return getMax(root.right);
    }
}
