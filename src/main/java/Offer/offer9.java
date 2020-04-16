package Offer;

public class offer9 {
    public int JumpFloorII(int target) {
        if (target<=0)return 0;
        if (target==1)return 1;
        if (target==2)return 2;

        int[] dp=new int[target];

        dp[0]=1;
        dp[1]=2;


        for (int i = 2; i < dp.length; i++) {
            for (int j = i; j >0 ; j--) {
                dp[i]+=dp[j-1];
            }
            dp[i]+=1;
        }
        return dp[target-1];
    }
}
