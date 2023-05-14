package LeetcodeAndOffer.Offer.StackQueueAndHeap;

import java.util.*;

public class Offer30 {

    private final LinkedList<Integer> stack;

    private final LinkedList<Integer> minList;

    Offer30() {
        stack = new LinkedList<>();
        minList = new LinkedList<>();
    }

    public void push(int x) {
        stack.addLast(x);
        minList.addLast(minList.isEmpty() ? x : Math.min(minList.getLast(),x));
    }

    public void pop() {
        stack.removeLast();
        minList.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int min() {
        return minList.getLast();
    }

}
