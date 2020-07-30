package Offer;

import java.util.ArrayList;

public class offer41 {
    //暴力法
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 1; i < sum; i++) {

            int temp=0;
            int j=i;
            while (temp<sum){
                temp+=j;
                j++;
            }
            if (temp==sum){
                ArrayList<Integer> array = new ArrayList<>();
                for (int k = i; k<=temp ; k++) {
                    array.add(k);
                    temp-=k;
                }
                list.add(array);
            }
        }
        return list;
    }
}
