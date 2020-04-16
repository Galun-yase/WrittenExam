import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution104 {

    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public int maxDepth2(TreeNode root) {
        if (root==null){return 0;}
        int layer=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            layer++;
            int size=queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode temp=queue.poll();
                if (temp.left!=null){queue.offer(temp.left);}
                if (temp.right!=null){queue.offer(temp.right);}
            }
        }
        return layer;
    }

}




//Definition for a binary tree node.
class TreeNode {
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode(int x) { val = x; }
}

