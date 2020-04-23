package Offer;

import java.util.Stack;

public class offer21 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack=new Stack<>();
        if (pushA.length!=popA.length)return false;

        int length=pushA.length;
        int i=0;
        int j=0;

        while (i<length && j<length){
            while (stack.empty() || stack.peek()!=popA[j]){
                stack.push(pushA[i]);
                i++;
                if (i>=length)break;
            }
            while (!stack.empty() && stack.peek()==popA[j] ){
                stack.pop();
                j++;
                if (j>=length)break;

            }
        }
        if (stack.empty())return true;
        return false;



    }
}
