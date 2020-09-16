package LeetCode;

import java.util.Arrays;

/**
 * @author 任青成
 * @date 2020/9/16 23:24
 */
//并查集
public class LC547 {
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent,-1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j]==1 && i!=j){
                    union(parent,i,j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i]==-1){
                count++;
            }
        }
        return count;
    }


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


}
