package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC84 {
    public int largestRectangleArea(int[] heights) {

        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }

        // 单调递减栈 存储最近最小的元素
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        for (int i = 0; i < newHeights.length; i++) {

            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                int popIndex = stack.pop();

                int curHeight = newHeights[popIndex];

                int right = i;
                int left = stack.peek();

                int curWidth = right - left - 1;

                res = Math.max(res, curWidth * curHeight);
            }
            stack.push(i);
        }
        return res;
    }

    public int largestRectangleArea_2(int[] heights) {
        int[] left = new int[heights.length + 2];
        int[] right = new int[heights.length + 2];


        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];

            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > height) {
                    Integer pop = stack.pop();

                    right[pop + 1] = i + 1;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            right[pop + 1] = right.length - 1;
        }

        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];

            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > height) {
                    Integer pop = stack.pop();

                    left[pop + 1] = i + 1;
                }
                stack.push(i);
            }
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (right[i + 1] - left[i + 1] - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 4};
        int i = new LC84().largestRectangleArea_2(a);
    }
}
