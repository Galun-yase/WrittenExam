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

    public int search_second(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
