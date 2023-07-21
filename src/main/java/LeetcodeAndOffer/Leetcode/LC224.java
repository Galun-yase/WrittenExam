package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        // 记录左边的值 运算符
        int res = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int value = c - '0';

                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    value = value * 10 + s.charAt(i) - '0';
                }
                // 拿到右边的值要计算完成
                res = sign * value + res;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);

                // 重新初始化
                res = 0;
                sign = 1;
            } else if (c == ')') {
                int popSign = stack.pop();
                int popRes = stack.pop();

                // 右边的值计算结束，也要计算完成再保存
                res = popSign * res + popRes;
            }
        }
        return res;
    }

}
