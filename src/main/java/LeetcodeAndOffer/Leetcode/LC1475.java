package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC1475 {
    public int[] finalPrices(int[] prices) {
        // 单调递减栈
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {

            int price = prices[i];

            // 需要弹出比当前价格大的值，保持单调递减
            while (!stack.isEmpty() && stack.peek() > price) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = price;
            } else {
                res[i] = price - stack.peek();
            }
            stack.push(price);
        }
        return res;
    }

    public int[] finalPrices_2(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && prices[stack.peek()] >= price) {
                    res[stack.peek()] = prices[stack.peek()] - price;
                    stack.pop();
                }

                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            res[index] = prices[index];
        }

        return res;
    }
}
