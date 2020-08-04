package Offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;


public class offer45 {
    //暴力法要考虑边界条件
    public boolean isContinuous(int [] numbers) {
        if (numbers.length<=0 || numbers==null)return false;
        int[] array = Arrays.stream(numbers).filter(e -> e != 0).sorted().toArray();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int e:array) {
            hashSet.add(e);
        }
        if (array.length!=hashSet.size()){
            return false;
        }

        int count_o = numbers.length - array.length;
        for (int i = 1; i < array.length; i++) {
            if (array[i]!=array[i-1]+1){
                count_o-=array[i]-array[i-1]-1;
            }
            if (count_o<0){
                return false;
            }
        }
        return true;


    }

    @Test
    public void test(){
        int[] a={1,3,0,7,0};
        boolean continuous = isContinuous(a);
        System.out.println(continuous);
    }
}
