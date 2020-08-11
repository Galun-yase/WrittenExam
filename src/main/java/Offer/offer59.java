package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 任青成
 * @date 2020/8/11 0:10
 */
public class offer59 {

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

        for (int i = 1; i < lists.size(); i+=2) {
            lists.get(i);
            Collections.reverse(lists.get(i));
        }

        return (ArrayList<ArrayList<Integer>>)lists;
    }

}
