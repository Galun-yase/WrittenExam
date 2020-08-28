package Exam;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author 任青成
 * @date 2020/8/28 11:34
 */
public class KJL2 {

    public void crossprint(int[] array,int n,int m){
        Arrays.sort(array);
        for (int i = n; i < array.length; i=i+n+m) {
            if (i+m-1<array.length){
                daoxu(array,i,i+m-1);
            }else {
                daoxu(array,i,array.length-1);
            }
        }
        System.out.println(Arrays.toString(array));

    }

    private void daoxu(int[] arr,int start,int end){
        while (start<end){
            swap(arr,start,end);
            start++;
            end--;
        }

    }


    private void swap(int[] arr,int i,int j){
        int t  = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }




}
