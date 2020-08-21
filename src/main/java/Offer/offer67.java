package Offer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author 任青成
 * @date 2020/8/21 20:23
 */
public class offer67 {

    //数学思想 o(n)了
    public int cutRope(int target) {
        TreeSet<Integer> set = new TreeSet<>((o1,o2)->o2.compareTo(o1));
        for (int i = 2; i <= target; i++) {
            set.add(maxChengJi(target,i));
        }
        return set.first();
    }
    private int maxChengJi(int n,int m){
        if (n==m)return 1;
        int one = n/m;
        int geshu = n%m;
        return  (int)(Math.pow(one, m - geshu) * Math.pow(one + 1, geshu));
    }

    public static void main(String[] args) {
        int i = new offer67().cutRopeDp(15);
        System.out.println(i);
    }


    //这种Dp就很奇怪 ，初始条件和Dp情况不同？？？ O(n2)
    //因为Dp时，有res[5]*1 有1的情况，所以初始条件按m可以为1的情况算
    public int cutRopeDp(int target) {
        if (target<=2)return target;
        int[] res = new int[target+1];
        res[1]=1;
        res[2]=2;
        res[3]=3;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j < i-1; j++) {
                res[i] = Math.max(res[i],res[i-j]*j);
            }
        }
        System.out.println(Arrays.toString(res));
        return res[target];
    }



}
