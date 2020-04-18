package Offer;

import java.util.ArrayList;

public class offer19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> arrayList=new ArrayList<>();
        if (matrix==null)return arrayList;


        int up=0;
        int down=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;

        while (up<=down &&left<=right){

            for (int i = left; i <= right; i++) {
                arrayList.add(matrix[up][i]);
            }
            for (int i = up+1; i <= down; i++) {
                arrayList.add(matrix[i][right]);
            }

            if (up<down){
                for (int i = right-1; i >=left ; i--) {
                    arrayList.add(matrix[down][i]);
                }
            }

            if (left<right){
                for (int i = down-1; i >up; i--) {
                    arrayList.add(matrix[i][left]);
                }
            }
            up++;
            down--;
            left++;
            right--;

        }
        return arrayList;
    }
}
