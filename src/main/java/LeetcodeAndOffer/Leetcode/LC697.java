package LeetcodeAndOffer.Leetcode;

import java.util.*;

public class LC697 {
    public int findShortestSubArray(int[] nums) {
        // 值:[出现次数，第一次出现位置，第二次出现位置]
        HashMap<Integer, int[]> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashMap.containsKey(num)) {
                int[] ints = hashMap.get(num);
                ints[0]++;
                ints[2] = i;
            } else {
                hashMap.put(num, new int[]{1, i, i});
            }
        }

        int value = 0;
        int length = nums.length;
        for (Map.Entry<Integer, int[]> entry : hashMap.entrySet()) {
            int[] ints = entry.getValue();
            if (ints[0] > value) {
                value = ints[0];
                length = ints[2] - ints[1] + 1;
            }
            if (ints[0] == value) {
                length = Math.max(length, ints[2] - ints[1] + 1);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 3, 1, 4, 2};
        int shortestSubArray = new LC697().findShortestSubArray_2(ints);
    }

    public int findShortestSubArray_2(int[] nums) {
        // num:[count,start,end]
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (hashMap.containsKey(num)) {
                ArrayList<Integer> list = hashMap.get(num);
                list.set(0, list.get(0) + 1);
                list.set(2, i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(i);
                list.add(i);
                hashMap.put(num, list);
            }
        }

        int maxValue = 0;
        int minRes = Integer.MAX_VALUE;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
            Integer num = entry.getKey();
            ArrayList<Integer> list = entry.getValue();

            if (list.get(0) > maxValue) {
                maxValue = list.get(0);
                minRes = list.get(2) - list.get(1) + 1;
            }
            if (list.get(0) == maxValue) {
                minRes = Math.min(minRes, list.get(2) - list.get(1) + 1);
            }
        }
        return minRes;
    }
}
