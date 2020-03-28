package FoundationDS;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Solution239 {

    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length<=1||k<=1){return nums;}

        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        int[] result=new int[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {

            while(!arrayDeque.isEmpty()&&nums[arrayDeque.peekLast()]<nums[i]){
                arrayDeque.pollLast();
            }
            arrayDeque.addLast(i);
            if (arrayDeque.peekFirst()+k<=i){
                arrayDeque.pollFirst();
            }
            if (i+1>=k){
                result[i+1-k]=nums[arrayDeque.peekFirst()];
            }
        }
        return result;
    }

}

/**
 * 滑动窗口类--双端队列，
 * 很巧妙，队首只保存最大值
 */