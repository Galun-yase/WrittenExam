package Offer;

import com.sun.org.apache.xpath.internal.objects.XBoolean;

import java.util.Arrays;

/**
 * @author 任青成
 * @date 2020/8/13 22:57
 */
//dfs
public class offer65 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] mat = new char[rows][cols];
        int d = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = matrix[d++];
            }
        }
        String s = new String(str);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visit = new boolean[rows][cols];
                if (f(mat,i,j,s,visit)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean f(char[][] mat, int i, int j, String s, boolean[][] visit){
        if (!(mat[i][j]==s.charAt(0)))return false;
        else if (s.length()==1)return true;
        visit[i][j]=true;
        boolean r = false;
        if (checkIndex(i+1,j,mat) && !visit[i+1][j]) r = r || f(mat,i+1,j,s.substring(1),visit);
        if (checkIndex(i-1,j,mat) && !visit[i-1][j]) r = r || f(mat,i-1,j,s.substring(1),visit);
        if (checkIndex(i,j+1,mat) && !visit[i][j+1]) r = r || f(mat,i,j+1,s.substring(1),visit);
        if (checkIndex(i,j-1,mat) && !visit[i][j-1]) r = r || f(mat,i,j-1,s.substring(1),visit);
        visit[i][j]=false;
        return r;
    }

    private boolean checkIndex(int i,int j,char[][] mat){
        if ( (0<=i && i <mat.length) && (0<=j&& j<mat[0].length))return true;
        else return false;
    }
}





















//public class offer65 {
//        public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
//            char[][] mat = new char[rows][cols];
//            for(int i = 0, k = 0; i < rows; ++i){//把矩阵二维存储
//                for(int j = 0; j < cols; ++j){
//                    mat[i][j] = matrix[k++];
//                }
//            }
//            String s = new String(str);//方便调用substring函数
//            for(int i = 0; i < rows; ++i){
//                for(int j = 0; j < cols; ++j){
//                    boolean[][] visit = new boolean[rows][cols];//标记是否重复访问
//                    if(f(mat, i, j, s, visit)) return true;//该点为起点能否形成路径
//                }
//            }
//            return false;
//        }
//        public static boolean f(char[][] mat, int i, int j, String s, boolean[][] visit){
//            if(mat[i][j] != s.charAt(0)) return false;
//            else if(s.length() == 1) return true;//最后一个字符被匹配上了
//            visit[i][j] = true;//标记该点已访问
//            boolean r = false;
//            if(g(i + 1, j, mat) && !visit[i + 1][j]) r = r||f(mat, i + 1, j, s.substring(1), visit);
//            if(g(i - 1, j, mat) && !visit[i - 1][j]) r = r||f(mat, i - 1, j, s.substring(1), visit);
//            if(g(i, j + 1, mat) && !visit[i][j + 1]) r = r||f(mat, i, j + 1, s.substring(1), visit);
//            if(g(i, j - 1, mat) && !visit[i][j - 1]) r = r||f(mat, i, j - 1, s.substring(1), visit);
//            visit[i][j] = false;//重置该点的访问权
//            return r;
//        }
//        public static boolean g(int i, int j, char[][] mat){//该点下标是否越界
//            if(i >= 0 && j >= 0 && i < mat.length && j < mat[0].length) return true;
//            return false;
//        }
//}
