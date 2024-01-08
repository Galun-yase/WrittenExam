package LeetcodeAndOffer.Leetcode;

public class LC485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        // 注意此处从-1开始
        int lastIndex = -1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                lastIndex = i;
            } else {
                res = Math.max(res, i - lastIndex);
            }
        }
        return res;
    }

    public int findMaxConsecutiveOnes_2(int[] nums) {
        int result = 0;

        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                slow = i + 1;
            }
            result = Math.max(result, i - slow + 1);
        }
        return result;
    }
}
