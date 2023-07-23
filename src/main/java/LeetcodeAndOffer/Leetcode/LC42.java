package LeetcodeAndOffer.Leetcode;

import java.util.Stack;

public class LC42 {
    public int trap(int[] height) {

        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer bottom = stack.pop();

                if (stack.isEmpty()) break;
                int h = Math.min(height[stack.peek()], height[i]) - height[bottom];
                int w = i - stack.peek() - 1;

                res += w * h;
            }
            stack.push(i);
        }
        return res;
    }
}
