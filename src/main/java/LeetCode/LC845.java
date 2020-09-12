package LeetCode;

/**
 * @author 任青成
 * @date 2020/9/9 14:25
 */
//数组中的最长山脉
public class LC845 {
    public int longestMountain(int[] A) {
        int N = A.length;
        int res = 0;
        int base = 0;
        while (base<N){
            int end = base;
            if (end+1>=N || A[end]>=A[end+1]){
                base++;
                continue;
            }
            while (end+1<N && A[end]<A[end+1]){
                end++;
            }
            while (end+1<N && A[end]>A[end+1]){
                end++;
                res = Math.max(end-base+1,res);
            }
            base = end;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={2,2,2};
        new LC845().longestMountain(arr);
    }
}
