package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;
import java.util.Map;

public class LC16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return res;
                }
            }
        }
        return res;
    }

    public int threeSumClosest_2(int[] nums, int target) {
        Arrays.sort(nums);

        int res = -100000;

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    res = Math.abs(target - sum) < Math.abs(target - res) ? sum : res;
                    left++;
                } else {
                    res = Math.abs(target - sum) < Math.abs(target - res) ? sum : res;
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {4, 0, 5, -5, 3, 3, 0, -4, -5};
        new LC16().threeSumClosest_2(ints, -2);
    }
}
