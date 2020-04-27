package Offer;

public class offer26 {
    TreeNode head=null;
    TreeNode plisthead=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return plisthead;
    }

    private void ConvertSub(TreeNode pRootOfTree){
        if (pRootOfTree==null)return;
        ConvertSub(pRootOfTree.left);
        if (head==null){
            head=pRootOfTree;
            plisthead=pRootOfTree;
        }else {
            head.right=pRootOfTree;
            pRootOfTree.left=head;
            head=pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}
