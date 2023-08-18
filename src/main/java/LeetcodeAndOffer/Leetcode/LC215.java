package LeetcodeAndOffer.Leetcode;

import java.util.Arrays;

public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSort(int[] nums, int left, int right, int index) {
        int mid = partition(nums, left, right);

        if (mid == index) {
            return nums[mid];
        } else if (mid > index) {
            return quickSort(nums, left, mid - 1, index);
        } else {
            return quickSort(nums, mid + 1, right, index);
        }

    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];

        while (left < right) {
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            nums[left] = nums[right];

            while (left < right && pivot <= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
