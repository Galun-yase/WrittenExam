package LeetcodeAndOffer.Leetcode;

public class LC209 {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int res = nums.length + 1;

        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
                res = Math.min(res, end - start + 1);

                sum -= nums[start];
                start++;
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }

    public int minSubArrayLen_2(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int res = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
