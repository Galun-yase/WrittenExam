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

    public int[] dailyTemperatures_second(int[] temperatures) {
        // 构建一个单调递增栈，保存下标
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperature) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures_3(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];

            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperature) {
                    Integer t = stack.pop();
                    int dis = i - t;
                    res[t] = dis;
                }
                stack.push(i);
            }
        }
        return res;
    }
}
