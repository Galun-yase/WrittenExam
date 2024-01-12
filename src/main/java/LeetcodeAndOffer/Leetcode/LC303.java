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

    class NumArray_2 {

        int[] prefixSum;

        public NumArray_2(int[] nums) {
            prefixSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];

        }
    }
}
