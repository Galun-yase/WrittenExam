package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 任青成
 * @date 2020/8/11 10:07
 */
public class offer60 {

    //双队列 层次遍历即可
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        List<ArrayList<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot!=null){
            queue.add(pRoot);
        }
        Queue<TreeNode> temp = new LinkedList<>();
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            for (TreeNode t:queue) {
                list.add(t.val);
                if (t.left!=null){
                    temp.add(t.left);
                }
                if (t.right!=null){
                    temp.add(t.right);
                }
            }
            lists.add(list);
            queue.clear();
            queue.addAll(temp);
            temp.clear();;
        }
        return (ArrayList<ArrayList<Integer>>)lists;
    }

}
