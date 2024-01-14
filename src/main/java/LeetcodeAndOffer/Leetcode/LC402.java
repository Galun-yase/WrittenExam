package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC402 {
    public String removeKdigits(String num, int k) {
        // 存放需要保留的数字
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            // 0开头的数字的不保留了
            if (stack.isEmpty() && digit == '0') {
                continue;
            }

            stack.push(digit);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) return "0";

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public String removeKdigits_2(String num, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';

            while (!stack.isEmpty() && k > 0 && stack.peek() > n) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        String string = sb.reverse().toString();

        while (string.startsWith("0")) {
            string = string.substring(1);
        }
        if (string.equals("")) return "0";

        return string;
    }
}
