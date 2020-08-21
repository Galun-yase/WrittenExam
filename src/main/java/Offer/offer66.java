package Offer;


import java.util.ArrayList;

/**
 * @author 任青成
 * @date 2020/8/15 0:10
 */
public class offer66 {

    /**
     * [][][][]
     * [][][][]
     * [][][][]
     *
     * （35,37）3+5+3+7=18<=18可以
     *
     */

    private int result = 1;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold<0)return 0;
        int[][] array = new int[rows][cols];
        array[0][0]=1;
        change(threshold,0,0,array);

        return result;
    }

    private void change(int key,int row,int col,int[][] arr){
        int chang = arr.length;
        int kuan = arr[0].length;

        if (row+1<chang && col <kuan){
            if (isCanIn(row+1,col,key)&&arr[row+1][col]!=1){
                arr[row+1][col]=1;
                result++;
                change(key,row+1,col,arr);
            }
        }
        if (row<chang && col+1 <kuan&&arr[row][col+1]!=1){
            if (isCanIn(row,col+1,key)){
                arr[row][col+1]=1;
                result++;
                change(key,row,col+1,arr);
            }
        }


    }

    private boolean isCanIn(int desr ,int desc, int key){
        int res = 0;
        while (desr>0){
            int ge = desr % 10;
            res += ge;
            desr = desr / 10;
        }
        while (desc>0){
            int ge = desc % 10;
            res += ge;
            desc = desc / 10;
        }
        if (res<=key)return true;
        else return false;
    }


}
