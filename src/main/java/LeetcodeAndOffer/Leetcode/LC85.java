package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC85 {
    public int maximalRectangle(char[][] matrix) {
        // 每一行去看待，拆解成一维的
        int[] heights = new int[matrix[0].length];

        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

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

                // popIndex的右边界
                int right = i;
                // popIndex的左边界 为单调递减栈的前一个元素
                int left = stack.peek();

                int curWidth = right - left - 1;

                res = Math.max(res, curWidth * curHeight);
            }
            stack.push(i);
        }
        return res;
    }

}
