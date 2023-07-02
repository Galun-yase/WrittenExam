package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LC20 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
            }

            if (c == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }

            if (c == ']' && stack.peek() == '[') {
                stack.pop();
                continue;
            }

            if (c == '}' && stack.peek() == '{') {
                stack.pop();
                continue;
            }
            return false;

        }
        return stack.isEmpty();


    }

}
