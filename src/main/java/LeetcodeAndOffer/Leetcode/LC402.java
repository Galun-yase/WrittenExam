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
}
