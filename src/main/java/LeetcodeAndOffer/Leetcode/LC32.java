package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC32 {
    public int longestValidParentheses(String s) {
        // 存储左括号的索引
        Stack<Integer> stack = new Stack<>();
        // 表示合法序列的初始位置
        int start = 0;

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - start + 1);
                    } else {
                        // 栈不为空，说明是嵌套括号,此时需要临时记录其中合法的有效长度，比如"(()",把后面的先记录下来
                        maxLength = Math.max(maxLength, i - (stack.peek() + 1) + 1);
                    }
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int i = new LC32().longestValidParentheses("(())");
        System.out.println(i);
    }
}
