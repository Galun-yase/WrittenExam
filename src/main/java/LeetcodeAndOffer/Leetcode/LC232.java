package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC232 {
    class MyQueue {

        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {

            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.pop();
        }

        public int peek() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.peek();
        }

        public boolean empty() {
            return stackOut.isEmpty() && stackIn.isEmpty();
        }
    }

    class MyQueue2 {

        Stack<Integer> stack;
        Stack<Integer> backStack;

        public MyQueue2() {
            stack = new Stack<>();
            backStack = new Stack<>();
        }

        public void push(int x) {
            backStack.push(x);
        }

        public int pop() {
            if (stack.isEmpty()) {
                while (!backStack.isEmpty()) {
                    stack.push(backStack.pop());
                }
            }
            return stack.pop();
        }

        public int peek() {
            if (stack.isEmpty()) {
                while (!backStack.isEmpty()) {
                    stack.push(backStack.pop());
                }
            }
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty() && backStack.isEmpty();
        }
    }
}
