package Exam;

import java.util.Arrays;

/**
 * @author 任青成
 * @date 2020/9/11 16:50
 */
public class Youzan4 {
    public int minMoves (int[] nums) {
        // write code here
        Arrays.sort(nums);
        int l = nums.length;
        if (l%2==0){
            return Math.min(dc(l/2-1,nums),dc(l/2,nums));
        }else {
            return dc(l/2,nums);
        }
    }
    private int dc(int index , int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res+=Math.abs(arr[i]-arr[index]);
        }
        return res;
    }
}
