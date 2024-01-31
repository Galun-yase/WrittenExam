package LeetcodeAndOffer.Leetcode;

public class LC154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] == nums[right]) {
                right--;
                continue;
            }

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

    public int findMin_2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int res = 5001;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[left] == nums[mid]) {
                res = Math.min(res, nums[left]);
                left++;
                continue;
            }

            if (nums[left] < nums[mid]) {
                res = Math.min(res, nums[left]);
                left = mid + 1;
            } else {
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            }
        }
        return res;
    }
}
