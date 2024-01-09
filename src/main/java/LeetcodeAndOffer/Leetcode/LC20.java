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

    public boolean isValid_second(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid_3(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }

        }

        return stack.isEmpty();
    }
}
