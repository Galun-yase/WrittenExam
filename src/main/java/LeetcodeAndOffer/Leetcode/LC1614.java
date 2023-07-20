package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC1614 {
    public int maxDepth(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            }
            res = Math.max(res, stack.size());
        }
        return res;
    }


}
