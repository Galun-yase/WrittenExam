package LeetcodeAndOffer.Leetcode;

import java.util.Objects;
import java.util.Stack;

public class LC150 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (Objects.equals(str, "+")) {
                Integer v1 = stack.pop();
                Integer v2 = stack.pop();
                stack.push(v1 + v2);
                continue;
            }
            if (Objects.equals(str, "-")) {
                Integer v1 = stack.pop();
                Integer v2 = stack.pop();
                stack.push(v2 - v1);
                continue;
            }
            if (Objects.equals(str, "*")) {
                Integer v1 = stack.pop();
                Integer v2 = stack.pop();
                stack.push(v2 * v1);
                continue;
            }
            if (Objects.equals(str, "/")) {
                Integer v1 = stack.pop();
                Integer v2 = stack.pop();
                stack.push(v2 / v1);
                continue;
            }
            stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }

    public int evalRPN_second(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (Objects.equals(s, "+")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num1 + num2);
                continue;
            }
            if (Objects.equals(s, "-")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 - num1);
                continue;
            }
            if (Objects.equals(s, "*")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num1 * num2);
                continue;
            }
            if (Objects.equals(s, "/")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2 / num1);
                continue;
            }
            stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String a = "王";
        String b = "a";


        System.out.println(a == b);

    }

    public int evalRPN_3(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (Objects.equals(token, "+")) {
                Integer first = stack.pop();
                Integer last = stack.pop();
                stack.push(last + first);

            } else if (Objects.equals(token, "-")) {
                Integer first = stack.pop();
                Integer last = stack.pop();
                stack.push(last - first);
            } else if (Objects.equals(token, "*")) {
                Integer first = stack.pop();
                Integer last = stack.pop();
                stack.push(last * first);
            } else if (Objects.equals(token, "/")) {
                Integer first = stack.pop();
                Integer last = stack.pop();
                stack.push(last / first);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}
