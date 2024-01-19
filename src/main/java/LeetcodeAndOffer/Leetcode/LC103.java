package LeetcodeAndOffer.Leetcode;

import java.util.*;

public class LC103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isLeft = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> tmp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (isLeft){
                    tmp.addLast(poll.val);
                }else {
                    tmp.addFirst(poll.val);
                }


                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            res.add(new LinkedList<>(tmp));
            isLeft = !isLeft;
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

    public List<List<Integer>> zigzagLevelOrder_2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        } else {
            queue.add(root);
        }

        boolean reverse = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                list.add(node.val);
            }

            if (reverse) {
                res.add(list);
                reverse = false;
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    tmp.add(list.get(i));
                }
                res.add(tmp);
                reverse = true;
            }
        }
        return res;
    }

}
