package LeetcodeAndOffer.Leetcode;

public class LC114 {
    public void flatten(TreeNode root) {
        flatten_return(root);
    }

    /**
     * 返回当前节点拉成链表后的尾节点
     */
    private TreeNode flatten_return(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        TreeNode left = root.left;
        TreeNode right = root.right;

        TreeNode leftTail = null;
        TreeNode rightTail = null;
        TreeNode tail = null;

        if (left != null) {
            leftTail = flatten_return(left);
            root.left = null;
            root.right = left;

            tail = leftTail;
        }

        if (right != null) {
            rightTail = flatten_return(right);

            // 没有左子树，即root.right还是指向right节点，不需要改变
            if (left != null) {
                leftTail.right = right;
            }
            tail = rightTail;
        }
        return tail;
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
