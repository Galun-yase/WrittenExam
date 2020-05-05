package Offer;

public class offer30 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n<=0)return 0;
        int count=0;
        for (int i = 1; i <= n; i*=10) {
            int k=i*10;
            count+=n/k*i+Math.max(Math.min(n%k-i+1,i),0);
        }
        return count;
    }
}
