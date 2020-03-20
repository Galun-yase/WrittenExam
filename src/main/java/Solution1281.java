public class Solution1281 {

    public int subtractProductAndSum(int n) {
        int ji=1;
        int sum=0;
        while (n!=0){
            ji*=n%10;
            sum+=n%10;
            n/=10;
        }
        return ji-sum;
    }
}
