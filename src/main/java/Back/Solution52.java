package Back;

import java.util.List;

class solution51 {

    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     */
    int count=0;
    public int totalNQueens(int n) {
        backtracking(n,0,new int[n]);
        return count;
    }

    private void backtracking(int n,int row,int[] columns){

        if (row==n){
            count++;
            return;
        }

        for (int col=0;col<n;col++){
            columns[row]=col;
            if (check(row,col,columns)){
                backtracking(n,row+1,columns);
            }
            columns[row]=-1;
        }


    }


    private boolean check(int row,int col,int[] colunums){

        for (int i = 0; i < row; i++) {

            if (col==colunums[i] || row-i==Math.abs(colunums[i]-col)){
                return false;
            }

        }
        return true;

    }
}
/**
 * 回溯，check为检查是否合法
 */