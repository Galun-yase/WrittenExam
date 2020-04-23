package Offer;

import java.util.Stack;

public class offer20 {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> stack_min=new Stack<>();

    public void push(int node) {
        if (stack.empty()){
            stack.push(node);
            stack_min.push(node);
        }else {
            if (node>stack_min.peek()){
                stack.push(node);
            }else {
                stack.push(node);
                stack_min.push(node);

            }
        }

    }

    public void pop() {
        if (stack.peek()==stack_min.peek()){
            stack_min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack_min.peek();
    }
}
