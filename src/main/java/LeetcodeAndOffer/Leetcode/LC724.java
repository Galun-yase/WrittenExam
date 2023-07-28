package LeetcodeAndOffer.Leetcode;

public class LC724 {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length + 2];
        int[] sufSum = new int[nums.length + 2];

        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            sufSum[i] = sufSum[i + 1] + nums[i];
        }

        for (int i = 1; i <= nums.length; i++) {
            if (preSum[i] == sufSum[i - 1]) return i - 1;
        }
        return -1;
    }

    public int pivotIndex_good(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
