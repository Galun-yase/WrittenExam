package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                tmp.add(poll.val);

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            res.add(tmp);
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

    public List<List<Integer>> levelOrder_2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayList<Integer> list12 = new ArrayList<>();
        list12.add(root.val);
        res.add(list12);


        List<TreeNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.left);
                list.add(node.right);
            }

            if (queue.isEmpty()) {
                queue.addAll(list);

                ArrayList<Integer> list1 = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    TreeNode treeNode = list.get(i);
                    if (treeNode != null) {
                        list1.add(treeNode.val);
                    }
                }

                if (list1.size() != 0) {
                    res.add(list1);

                }
                list.clear();
            }

        }

        return res;
    }
}
