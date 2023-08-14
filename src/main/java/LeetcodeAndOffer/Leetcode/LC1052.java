package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;

public class LC1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] unsatisfied = new int[customers.length];

        for (int i = 0; i < customers.length; i++) {
            unsatisfied[i] = customers[i] * grumpy[i];
        }

        int res = 0;
        int maxSum = 0;
        int start = 0;
        for (int end = 0; end < unsatisfied.length; end++) {
            maxSum += unsatisfied[end];

            if (end - start + 1 == minutes) {
                res = Math.max(res, maxSum);
                maxSum -= unsatisfied[start];
                start++;
            }
        }

        return Arrays.stream(customers).sum() - Arrays.stream(unsatisfied).sum() + res;
    }

    public static void main(String[] args) {

        int[] a = {1,0,1,2,1,1,7,5};
        int[] b = {0,1,0,1,0,1,0,1};

        int mid = new LC1052().maxSatisfied(a, b, 3);

    }
}
