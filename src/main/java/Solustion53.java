import java.util.Arrays;

public class Solustion53 {


    public int maxSubArray(int[] nums) {
        int temp=Integer.MIN_VALUE;
        for (int i=1;i<nums.length+1;i++){
            temp=Math.max(temp,sum(nums,i));
        }
        return temp;
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
