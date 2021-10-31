package LeetCode;

import java.util.Arrays;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp[i] = Math.max((temp[i-1] + nums[i]), nums[i]);
        }
        Arrays.sort(temp);

        return temp[nums.length-1];
    }
}
