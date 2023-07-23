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
}
