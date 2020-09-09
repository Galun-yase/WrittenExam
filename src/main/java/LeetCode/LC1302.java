package LeetCode;

/**
 * @author 任青成
 * @date 2020/9/8 10:20
 */
//成熟最深叶子节点的和
public class LC1302 {

    int sum = 0;
    int deep = 0;
    public int sumdeepestnode(TreeNode root){
        if (root!=null){
            dfs(root,0);
        }
        return sum;
    }

    private void dfs(TreeNode root, int level){
        if (root==null)return;
        if (root.left==null && root.right==null){
            if (deep<level){
                deep = level;
                sum = root.val;
            }else if (level==deep){
                sum += root.val;
            }else {

            }
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}
