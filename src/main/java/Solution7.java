import java.util.Deque;
import java.util.LinkedList;

public class Solution7 {

    public static int reverse(int x) {
        String temp=""+x;
        Deque deque=new LinkedList();
        if (x>=0){

            for (int i=0;i<temp.length();i++){
                deque.push(temp.charAt(i));
            }

        }else {
            for (int i=1;i<temp.length();i++){
                deque.push(temp.charAt(i));
            }
        }
        String str="";
        while (deque.peek()!=null){
            str=str+deque.pop();
        }
        long ans=0;
        if (str!=""||str!=null){
            ans=Long.parseLong(str);
        }
        if (ans<Math.pow(-2,31)||ans>Math.pow(2,31)-1){
            return 0;
        }
        return (int)ans;
    }

    public static int reverse2(int x) {
        int ans=0;
        while (x!=0){
            int pop=x%10;
            if (ans>Integer.MAX_VALUE/10 ||(ans==Integer.MAX_VALUE&&pop>7)){
                return 0;
            }
            if (ans<Integer.MIN_VALUE/10 ||(ans==Integer.MIN_VALUE&&pop<-8)){
                return 0;
            }
            ans=ans*10+pop;
            x/=10;
        }
        return ans;
    }
    public static void main(String[] args){
            System.out.println(Solution7.reverse(123));
    }
}
