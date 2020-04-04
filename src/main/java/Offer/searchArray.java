package Offer;

import java.util.Arrays;

public class searchArray {


    public boolean Find(int target, int [][] array) {

        for (int i = 0; i < array.length; i++) {
            int result=BinarySearch(array[i],target);
            if (result!=-1){
                return true;
            }
        }
        return false;

    }


    public  int BinarySearch(int[] seqList,int key){
        int begin=0;
        int end=seqList.length-1;
        int mid;
        while (begin<=end){
            mid=(begin+end)/2;
            if (seqList[mid]==key){
                return mid;
            }else if (key<seqList[mid]){
                end=mid-1;
            }else {
                begin=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] list={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        searchArray a=new searchArray();


        System.out.println(a.Find(1,list));
        System.out.println(list[0][0]);
    }
}
