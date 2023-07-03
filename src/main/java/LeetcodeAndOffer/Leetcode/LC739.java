package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack_index = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack_index.isEmpty() && temperatures[i] > temperatures[stack_index.peek()]) {

                Integer pop_index = stack_index.pop();
                res[pop_index] = i - pop_index;

            }
            stack_index.push(i);
        }
        return res;
    }

}
