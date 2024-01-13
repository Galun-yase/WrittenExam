package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;
import java.util.Stack;

public class LC496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums2.length];


        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    int pop = stack.pop();
                    res[pop] = i;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            res[stack.peek()] = -1;
            stack.pop();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            hashMap.put(nums2[i], res[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer index = hashMap.get(nums1[i]);
            if (index == -1) {
                ans[i] = -1;
            } else {
                ans[i] = nums2[hashMap.get(nums1[i])];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ints1 = {4, 1, 2};
        int[] ints2 = {1, 3, 4, 2};
        int[] ints = new LC496().nextGreaterElement(ints1, ints2);

    }

    public int[] nextGreaterElement_2(int[] nums1, int[] nums2) {

        // 存储当前key的下一个最大元素value
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                Integer k = stack.pop();
                hashMap.put(k, nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            Integer k = stack.pop();
            hashMap.put(k, -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
    }

}
