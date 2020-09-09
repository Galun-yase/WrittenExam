package Offer;

public class offer26 {

    TreeNode head = null;
    TreeNode pheadlist=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null)return null;
        ConvertSub(pRootOfTree);
        return pheadlist;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if (pRootOfTree==null)return;
        ConvertSub(pRootOfTree.left);
        if (head==null && pheadlist==null){
            head = pRootOfTree;
            pheadlist = pRootOfTree;
        }else {
            head.right=pRootOfTree;
            pRootOfTree.left=head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}
//    TreeNode head=null;
//    TreeNode plisthead=null;
//    public TreeNode Convert(TreeNode pRootOfTree) {
//        ConvertSub(pRootOfTree);
//        return plisthead;
//    }
//
//    private void ConvertSub(TreeNode pRootOfTree){
//        if (pRootOfTree==null)return;
//        ConvertSub(pRootOfTree.left);
//        if (head==null){
//            head=pRootOfTree;
//            plisthead=pRootOfTree;
//        }else {
//            head.right=pRootOfTree;
//            pRootOfTree.left=head;
//            head=pRootOfTree;
//        }
//        ConvertSub(pRootOfTree.right);
//    }