package Offer;

public class offer39 {
    public int TreeDepth1(TreeNode root) {
        if (root==null)return 0;
        int left = TreeDepth1(root.left);
        int right= TreeDepth1(root.right);
        return Math.max(left,right)+1;

    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null)return true;
        int left = TreeDepth1(root.left);
        int right = TreeDepth1(root.right);
        if (Math.abs(left-right)>1){
            return false;
        }
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }
}
