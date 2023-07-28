package LeetcodeAndOffer.Leetcode;

public class LC303 {
    class NumArray {

        private int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return left == 0 ? prefixSum[right] : prefixSum[right] - prefixSum[left - 1];
        }
    }
}
