package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LC144 二叉树的前序遍历
 * LC94 二叉树的中序遍历
 * LC145 二叉树的后序遍历
 */
public class LC144 {

    // 递归版本
    public List<Integer> preorderTraversal_digui(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preorderTraversal_digui(root, res);
        return res;
    }

    private void preorderTraversal_digui(TreeNode root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);
        preorderTraversal_digui(root.left, res);
        preorderTraversal_digui(root.right, res);
    }


    // 迭代版本
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> preorderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        int leftState = 10;
        int rightState = 20;
        int upState = 30;

        TreeNode node = root;
        int nodeState = leftState;

        while (node != null) {
            if (nodeState == leftState) {
//                前序遍历
                preorderList.add(node.val);
                if (node.left != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    nodeState = rightState;
                }


            } else if (nodeState == rightState) {
                // 中序遍历
                // preorderList.add(node.val);
                if (node.right != null) {
                    stack.push(node);
                    node = node.right;
                    nodeState = leftState;
                } else {
                    nodeState = upState;
                }


            } else {
                // 后序遍历
                // preorderList.add(node.val);
                TreeNode parent = null;
                if (!stack.isEmpty()) {
                    parent = stack.pop();
                    if (parent.left == node) {
                        nodeState = rightState;
                    }

                }
                node = parent;
            }
        }
        return preorderList;
    }


    class TreeNode {
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



