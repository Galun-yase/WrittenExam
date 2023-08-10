package LeetcodeAndOffer.Leetcode;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

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

        // 注意边界值
        if (left == nums.length) return left;
        return nums[left] > target ? left : left + 1;
    }
}
