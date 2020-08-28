package LeetCode;

public class Solution9 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int temp=0;
        int temp2=x;
        while (temp2>0){
            temp=temp*10+temp2%10;
            temp2/=10;
        }
        if (x!=temp){
            return false;
        }
        return true;
    }
}
