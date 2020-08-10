package Offer;

/**
 * @author 任青成
 * @date 2020/8/10 0:32
 */
public class offer58 {


    //递归比较  之前中序遍历只能90%,
    private boolean isSame(TreeNode p1, TreeNode p2){
        if (p1==null && p2==null)return true;
        if ((p1!=null && p2==null) || (p1==null && p2!=null))return false;

        return p1.val==p2.val && isSame(p1.left,p2.right) && isSame(p1.right,p2.left);
    }


    boolean isSymmetrical(TreeNode pRoot) {
        return isSame(pRoot,pRoot);

    }

}
