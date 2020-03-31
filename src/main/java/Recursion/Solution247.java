package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution247 {

    /**
     * LeetCode 第 247 题：找到所有长度为 n 的中心对称数。
     *
     *  
     *
     * 示例
     *
     * 输入:  n = 2
     *
     * 输出: ["11","69","88","96"]

     */
    static List<String> helper(int n,int m){

        if (n<0 || m<0 || n>m){
            throw new RuntimeException("invalid input");
        }

        if (n==0) return new ArrayList<String>(Arrays.asList(""));
        if (n==1) return new ArrayList<String>(Arrays.asList("0","1","8"));

        List<String> list=helper(n-2,m);

        List<String> res=new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s =list.get(i);

            if (n!=m) res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("8"+s+"8");
            res.add("9"+s+"6");

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution247.helper(5,5).toString());
    }


}
