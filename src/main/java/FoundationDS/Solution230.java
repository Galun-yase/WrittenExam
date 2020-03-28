package FoundationDS;

import java.util.ArrayDeque;

public class Solution230 {
    /**
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     */
    public int kthSmallest(TreeNode root, int k) {

        ArrayDeque<TreeNode> arrayDeque=new ArrayDeque();

        while (true){

            while (root!=null){

                arrayDeque.addLast(root);
                root=root.left;

            }
            root=arrayDeque.removeLast();
            if (--k==0)return root.val;
            root=root.right;
        }
    }
}




class TreeNode {
     int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

}

/**
 * 可以中序遍历完，取k-1位置的元素
 *用栈时，可以避免全部遍历元素
 */
