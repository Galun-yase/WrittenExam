package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 任青成
 * @date 2020/8/9 23:23
 */

//先找到根节点，然后中序遍历即可
public class offer57 {
    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode==null)return null;

        TreeLinkNode tt = pNode;
        while (tt.next!=null){
            tt=tt.next;
        }
        mid(tt);

        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).val==pNode.val){
                return list.get(i+1);
            }
        }
        return null;

    }
    private List<TreeLinkNode> list = new ArrayList<>();
    private void mid(TreeLinkNode root){
        if (root!=null){
            mid(root.left);
            list.add(root);
            mid(root.right);
        }

    }

}
