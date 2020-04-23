package Offer;

public class offer4 {

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        TreeNode root=re(pre,0,pre.length-1,in,0,in.length-1);
        return root;

    }


    private TreeNode re(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if (startPre>endPre || startIn>endIn){
            return null;
        }

        TreeNode root=new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {

            if (in[i]==pre[startPre]){
                root.left=re(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=re(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }

        }
        return root;




    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}