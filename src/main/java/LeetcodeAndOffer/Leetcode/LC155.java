package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC155 {

    static class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;


        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);

            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                Integer top = minStack.peek();

                if (val <= top) {
                    minStack.push(val);
                }
            }

        }

        public void pop() {
            int pop = stack.pop();
            int top = minStack.peek();
            // 此处不要使用Integer
            if (pop == top) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(-512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}


