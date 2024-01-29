package LeetcodeAndOffer.Leetcode;

public class LC136 {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public int singleNumber_2(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = res^nums[i];
        }
        return res;
    }
}
