package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author 任青成
 * @date 2020/9/9 21:23
 */
//输入: ["2", "1", "+", "3", "*"]
//输出: 9
//解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
public class LC150 {
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList();
        for (int i = 0; i < tokens.length; i++) {
            if (isOpration(tokens[i])){
                int B = Integer.parseInt(stack.removeFirst());
                int A = Integer.parseInt(stack.removeFirst());
                int res = 0;
                switch (tokens[i].charAt(0)){
                    case '+':
                        res = A + B;
                        stack.addFirst(Integer.toString(res));
                        break;
                    case '-':
                        res = A - B;
                        stack.addFirst(Integer.toString(res));
                        break;
                    case '*':
                        res = A * B;
                        stack.addFirst(Integer.toString(res));
                        break;
                    case '/':
                        res = A / B;
                        stack.addFirst(Integer.toString(res));
                        break;
                }

            }else {
                stack.addFirst(tokens[i]);
            }
        }
        return Integer.parseInt(stack.removeFirst());
    }

    private boolean isOpration(String c){

        return c.length()==1 && (c.charAt(0)>'9' || c.charAt(0) < '0');
    }

    public static void main(String[] args) {
        String[] arr = {"2", "1", "+", "3", "*"};
        int i = new LC150().evalRPN(arr);
        System.out.println(i);
    }
}
