package LeetcodeAndOffer.Leetcode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LC297 {

    // 按层序遍历二叉树，且节点的左右节点为空也要保存

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder("[");
        sb.append(root.val).append(",");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    sb.append(node.left.val).append(",");
                    queue.add(node.left);
                } else {
                    sb.append("null").append(",");
                }

                if (node.right != null) {
                    sb.append(node.right.val).append(",");
                    queue.add(node.right);
                } else {
                    sb.append("null").append(",");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;

        String[] vals = data.substring(1, data.length() - 1).split(",");

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!Objects.equals(vals[index], "null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(vals[index]));
                    node.left = left;
                    queue.add(left);
                }
                index++;

                if (!Objects.equals(vals[index], "null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(vals[index]));
                    node.right = right;
                    queue.add(right);
                }
                index++;
            }
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
