package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                if (i == size - 1) res.add(node.val);
            }
        }
        return res;
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

    public List<Integer> rightSideView_2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                if (i == size - 1) res.add(node.val);
            }
        }
        return res;
    }
}
