package Back;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> res=new ArrayList<>();

        backtracing(candidates,target,0,lists,res);

        return lists;
    }

    private void backtracing(int[] candidates,int target,int start,List<List<Integer>> lists,List<Integer> res){

        if (target==0){
            lists.add(new ArrayList<>(res));
            return;
        }else if (target<=0)return;

        for (int i=start;i<candidates.length;i++){

            res.add(candidates[i]);
            backtracing(candidates, target-candidates[i], i, lists, res);
            res.remove(res.size()-1);

        }



    }

}
/**
 * 回溯算法
 */