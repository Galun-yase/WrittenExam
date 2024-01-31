package LeetcodeAndOffer.Leetcode;

public class LC189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start++;
            end--;
        }
    }


    public void rotate_2(int[] nums, int k) {
        k = k % nums.length;

        reverse_2(nums, 0, nums.length - 1);
        reverse_2(nums, 0, k - 1);
        reverse_2(nums, k, nums.length - 1);
    }


    private void reverse_2(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];

            nums[start] = nums[end];
            nums[end] = tmp;

            start++;
            end--;
        }
    }
}
