package Offer;

import java.util.LinkedList;
import java.util.Queue;

public class offer38 {
    //递归
    public int TreeDepth1(TreeNode root) {
        if (root==null)return 0;
        int left = TreeDepth1(root.left);
        int right= TreeDepth1(root.right);
        return Math.max(left,right)+1;

    }

    //广度遍历
    public int TreeDepth2(TreeNode root) {
        if (root==null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int d=0;
        int count = 0;
        int nextcount=queue.size();
        while (!queue.isEmpty()){
            TreeNode t = queue.remove();
            count++;
            if (t.left!=null){
                queue.add(t.left);
            }
            if (t.right!=null){
                queue.add(t.right);
            }

            if (count == nextcount){
                d++;
                count=0;
                nextcount=queue.size();
            }
        }
        return d;
    }
}
