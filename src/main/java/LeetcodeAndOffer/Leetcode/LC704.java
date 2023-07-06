package LeetcodeAndOffer.Leetcode;

public class LC704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid_index = (left + right) / 2;

            if (target < nums[mid_index]) {
                right = mid_index - 1;
            } else if (target > nums[mid_index]) {
                left = mid_index + 1;
            } else {
                return mid_index;
            }
        }
        return -1;
    }
}
