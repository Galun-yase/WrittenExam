package LeetCode;

import java.util.HashMap;

/**
 * @author 任青成
 * @date 2020/8/22 16:43
 */
//o(n)一遍哈希法
public class s1 {

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                arr[0]=(int)map.get(target-nums[i]);
                arr[1]=i;
            }
            map.put(nums[i],i);
        }
        return arr;
    }

}
