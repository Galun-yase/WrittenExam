package Offer;

import java.util.ArrayList;

/**
 * @author 任青成
 * @date 2020/8/13 0:17
 */

//中序遍历   更好的应该是 深度搜索dfs
public class offer62 {

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot==null || k<=0)return null;
        pre(pRoot);
        if (k>list.size()) return null;
        return list.get(k-1);

    }

    ArrayList<TreeNode> list = new ArrayList<>();
    void pre(TreeNode root){
        if (root!=null){
            pre(root.left);
            list.add(root);
            pre(root.right);
        }
    }

}
