package LeetcodeAndOffer.Leetcode;

import javafx.util.Pair;

import java.util.Map;
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

    public int trap_2(int[] height) {

        // key位index，value为高度
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        int res = 0;

        for (int i = 0; i < height.length; i++) {
            int h = height[i];

            while (!stack.isEmpty() && stack.peek().getValue() <= h) {
                Pair<Integer, Integer> pop = stack.pop();
                Integer value = pop.getValue();

                if (!stack.isEmpty()) {
                    int min = Math.min(stack.peek().getValue(), h) - value;

                    int d = i - stack.peek().getKey() - 1;
                    res += min * d;
                }
            }

            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i, h);
            stack.push(pair);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int i = new LC42().trap_2(ints);
    }
}
