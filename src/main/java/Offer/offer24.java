package Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class offer24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> cur=new ArrayList<>();

        helper(root,target,cur,res);

        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size()>=o2.size()){
                    return -1;
                }else {
                    return 1;
                }
            }
        });

        return res;


    }

    private void helper(TreeNode root, int target, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res){
        if (root==null)return;
        cur.add(root.val);
        if (root.val==target && root.left==null && root.right==null){
            res.add(new ArrayList<>(cur));
        }else {
            helper(root.left,target-root.val,cur,res);
            helper(root.right,target-root.val,cur,res);
        }
        cur.remove(cur.size()-1);

    }
}
