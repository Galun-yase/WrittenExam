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

    static class TreeNode {
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

    public void flatten_2(TreeNode root) {
        flatten_return_2(root);
    }

    private TreeNode flatten_return_2(TreeNode root) {

        if (root == null) return root;

        TreeNode left = flatten_return_2(root.left);
        TreeNode right = flatten_return_2(root.right);

        if (left == null) {
            root.right = right;
            return root;
        } else {
            root.right = left;

            TreeNode cur = left;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = right;
        }
        root.left = null;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(4);
        TreeNode r = new TreeNode(5);
        TreeNode rr = new TreeNode(6);

        root.left = l;
        root.right = r;

        l.left = ll;
        l.right = lr;

        r.right = rr;

        new LC114().flatten_2(root);


    }
}
