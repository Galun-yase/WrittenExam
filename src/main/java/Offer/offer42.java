package Offer;

import java.util.ArrayList;

public class offer42 {


    //双指针 要考虑临界情况
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array.length==0) {
            return new ArrayList<>();
        }
        int i =0;
        int j =array.length-1;
        int count = array[i]+array[j];
        while (count!=sum){
            if (count<sum){
                i++;
            }
            if (count>sum){
                j--;
            }
            if (i>j){
                return new ArrayList<>();
            }
            count = array[i]+array[j];
        }
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(array[i]);
        objects.add(array[j]);
        return objects;
    }
}
