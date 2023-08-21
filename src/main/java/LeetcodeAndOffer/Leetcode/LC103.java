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

}
