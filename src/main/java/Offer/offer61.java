package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 任青成
 * @date 2020/8/11 20:32
 */

//递归序列化，
//递归反序列化 遇到#即变到右子树
public class offer61 {

    String Serialize(TreeNode root) {
        if (root==null)return "#!";

        return ""+root.val+"!"+Serialize(root.left)+Serialize(root.right);

    }
    // 1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!
    TreeNode Deserialize(String str) {
        String[] nodelist = str.split("!");
        if (nodelist.length==0)return null;
        List<String> nodelist1 = new ArrayList<>(Arrays.asList(nodelist));
        return rDeserialize(nodelist1);

    }

    TreeNode rDeserialize(List<String> nodelist){
        if ("#".equals(nodelist.get(0))){
            nodelist.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodelist.get(0)));
        nodelist.remove(0);
        root.left=rDeserialize(nodelist);
        root.right=rDeserialize(nodelist);
        return root;


    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.println(new offer61().Serialize(treeNode1));
        System.out.println(new offer61().Deserialize("1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!"));

    }


}