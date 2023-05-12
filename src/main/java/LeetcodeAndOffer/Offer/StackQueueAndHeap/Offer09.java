package LeetcodeAndOffer.Offer.StackQueueAndHeap;

import java.util.Stack;

public class Offer09 {
    public static void main(String[] args) {
        // 双栈实现队列
    }
}

class CQueue {

    private Stack<Integer> stackForIn;
    private Stack<Integer> stackForOut;

    public CQueue() {
        stackForIn = new Stack<>();
        stackForOut = new Stack<>();
    }

    public void appendTail(int value) {
        while (!stackForOut.isEmpty()){
            stackForIn.push(stackForOut.pop());
        }
        stackForOut.push(value);
        while (!stackForIn.isEmpty()){
            stackForOut.push(stackForIn.pop());
        }

    }

    public int deleteHead() {
        if (stackForOut.isEmpty()) return -1;
        return stackForOut.pop();
    }
}
