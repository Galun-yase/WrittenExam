package Offer;

public class offer17 {
    public  boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1==null || root2==null)return false;
        return isSub(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right,root2);

    }


    //判断子结构
    private boolean isSub(TreeNode node1, TreeNode node2){
        if (node2==null)return true;
        if (node1==null)return false;
        if (node1.val!=node2.val)return false;
        return isSub(node1.left,node2.left) && isSub(node1.right, node2.right);



    }


    //判断子树
    private   boolean isSame(TreeNode node1, TreeNode node2){

        if ((node1==null && node2!=null) || (node1!=null && node2==null))return false;
        if (node1==node2)return true;
        if (node1.val!=node2.val)return false;
        return isSame(node1.left,node2.left) && isSame(node1.right,node2.right);


    }
}
