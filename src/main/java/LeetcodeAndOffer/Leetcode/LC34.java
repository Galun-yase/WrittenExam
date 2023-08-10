package LeetcodeAndOffer.Leetcode;

public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (index == -1) return new int[]{-1, -1};
        int firstIndex = index;
        int lastIndex = index;

        while (firstIndex > 0 && nums[firstIndex - 1] == nums[firstIndex]) {
            firstIndex--;
        }
        while (lastIndex < nums.length - 1 && nums[lastIndex + 1] == nums[lastIndex]) {
            lastIndex++;
        }
        return new int[]{firstIndex, lastIndex};
    }
}
