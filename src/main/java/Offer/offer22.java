package Offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class offer22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        LinkedList<TreeNode> queue=new LinkedList();
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (root==null)return arrayList;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curr=queue.removeFirst();
            if (curr.left!=null){
                queue.addLast(curr.left);
            }
            if (curr.right!=null){
                queue.addLast(curr.right);
            }
            arrayList.add(curr.val);
        }


        return arrayList;
    }
}
