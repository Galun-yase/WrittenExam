package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC394 {

    public String decodeString(String s) {
        // 存储[前的数字
        Stack<Integer> numStack = new Stack<>();
        // 存储[前的字符串
        Stack<StringBuilder> strStack = new Stack<>();

        int digit = 0;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = c - '0';
                digit = digit * 10 + num;
            } else if (Character.isLowerCase(c)) {
                res.append(c);
            } else if (c == '[') {
                numStack.push(digit);
                strStack.push(res);

                digit = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                Integer num = numStack.pop();
                StringBuilder str = strStack.pop();

                for (int j = 0; j < num; j++) {
                    str.append(res);
                }
                res = str;
            }
        }
        return res.toString();
    }

    public String decodeString_2(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ('0' <= c && c <= '9') {
                num = num * 10 + Character.digit(c, 10);
            } else if (Character.isLowerCase(c)) {
                sb.append(c);
            } else if (c == '[') {
                numberStack.push(num);
                strStack.push(sb);

                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                Integer k = numberStack.pop();
                StringBuilder str = strStack.pop();

                for (int j = 0; j < k; j++) {
                    str.append(sb);
                }

                sb = str;
            }
        }
        return sb.toString();
    }
}
