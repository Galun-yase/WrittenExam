package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] array=Arrays.copyOf(nums,nums.length);
        Arrays.sort(array);
        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < nums.length ; i++) {
            if (i==0){
                map.put(array[i],0);
            }else {
                if (array[i]>array[i-1]){
                    map.put(array[i],i);
                }else {
                    map.put(array[i],map.get(array[i-1]));
                }
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            array[i]=map.get(nums[i]);
        }
        return array;

    }
}
