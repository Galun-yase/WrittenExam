package LeetCode;

import java.util.Arrays;

/**
 * @author 任青成
 * @date 2020/9/16 23:46
 */
//并查集
public class LC990 {
    private int find(int[] parent,int p){
        if (parent[p]==-1){
            return p;
        }
        return find(parent,parent[p]);
    }
    private void union(int[] parent,int p,int q){
        int pset = find(parent, p);
        int qset = find(parent, q);
        if (pset!=qset){
            parent[pset]=qset;
        }
    }

    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        int[] parent = new int[26];
        Arrays.fill(parent,-1);

        for (String str:equations) {
            if (str.charAt(1)!='!'){
                int start = str.charAt(0)-'a';
                int end = str.charAt(3)-'a';
                union(parent,start,end);
            }
        }
        for (String str:equations) {
            if (str.charAt(1)=='!'){
                int start = str.charAt(0)-'a';
                int end = str.charAt(3)-'a';
                if (find(parent,start)==find(parent,end)){
                    return false;
                }
            }
        }
        return true;
    }
}
