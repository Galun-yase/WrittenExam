package LeetCode;

/**
 * @author 任青成
 * @date 2020/9/9 13:25
 */
//最长上升子序列（不连续）
public class LC300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0)return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    res = Math.max(dp[i],res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr ={10,9,2,5,3,7,101,18};
        new LC300().lengthOfLIS(arr);
    }
}
