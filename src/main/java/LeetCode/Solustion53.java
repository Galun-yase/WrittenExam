package LeetCode;

import java.util.Arrays;

public class Solustion53 {

   //贪心思想
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int currSum=nums[0];int maxSum=nums[0];
        for (int i = 1; i <n ; i++) {
        currSum=Math.max(nums[i],currSum+nums[i]);
        maxSum=Math.max(currSum,maxSum);
    }
        return maxSum;
}


    //动态规划，修改数组
    public int maxSubArray2(int[] nums) {
     int n=nums.length;
     int maxSum=nums[0];
     for (int i = 1; i < n; i++) {
         if (nums[i-1]>0){nums[i]+=nums[i-1];}
         maxSum=Math.max(maxSum,nums[i]);
     }
     return maxSum;
    }






    private int sum(int[] nums,int n){
        int value=0;
        for (int i = 0; i < nums.length-n+1; i++) {
            int count=0;
            for (int j=i;j<i+n;j++){
                count+=nums[j];
            }
            value=Math.max(value,count);

        }
    return value;
    }
}












    //一种超出时间限制的解法
//    public int maxSubArray(int[] nums) {
//        int temp=Integer.MIN_VALUE;
//        for (int i=1;i<nums.length+1;i++){
//            temp=Math.max(temp,sum(nums,i));
//        }
//        return temp;
//    }
//
//
//    private int sum(int[] nums,int n){
//        int value=0;
//        for (int i = 0; i < nums.length-n+1; i++) {
//            int count=0;
//            for (int j=i;j<i+n;j++){
//                count+=nums[j];
//            }
//            value=Math.max(value,count);
//
//        }
//        return value;
//    }
//}
