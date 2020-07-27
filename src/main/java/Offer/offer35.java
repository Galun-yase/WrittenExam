package Offer;

import java.util.Arrays;

public class offer35 {

    public static int[] multiply(int[] A) {
        int[] left = new int[A.length];
        int[] right= new int[A.length];
        left[0]=1;
        right[A.length-1]=1;
        for (int i = 1; i < A.length; i++) {
            left[i]=left[i-1]*A[i-1];
        }
        for (int i = A.length-2; i >=0 ; i--) {
            right[i]=right[i+1]*A[i+1];
        }

        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i]=left[i]*right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        offer35.multiply(a);

    }



}