package Offer;

import java.util.Arrays;

public class offer4 {

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        TreeNode root=re(pre,0,pre.length-1,in,0,in.length-1);
        return root;

    }

    private TreeNode re(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart>preEnd || inStart>inEnd)return null;
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = 0; i < in.length; i++) {
            if (in[i]==pre[preStart]){
                int c1 = i - inStart;
                root.left=re(pre,preStart+1,preStart+c1,in,inStart,i-1);
                root.right=re(pre,preStart+c1+1,preEnd,in,i+1,inEnd);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {3,2,4,1,6,5,7};

        System.out.println(Arrays.binarySearch(b,2));


    }









//    private TreeNode re(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
//        if (startPre>endPre || startIn>endIn){
//            return null;
//        }
//
//        TreeNode root=new TreeNode(pre[startPre]);
//
//        for (int i = startIn; i <= endIn; i++) {
//
//            if (in[i]==pre[startPre]){
//                root.left=re(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
//                root.right=re(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
//            }
//
//        }
//        return root;
//    }
}
