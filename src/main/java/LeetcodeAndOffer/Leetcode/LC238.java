package LeetcodeAndOffer.Leetcode;

public class LC238 {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] ans = new int[nums.length];

        left[0] = 1;
        right[right.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

    public int[] productExceptSelf_2(int[] nums) {

        int[] left = new int[nums.length + 1];
        int[] right = new int[nums.length + 1];
        left[0] = 1;
        right[right.length - 1] = 1;


        for (int i = 0; i < nums.length; i++) {
            left[i + 1] = left[i] * nums[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }


        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i + 1];
        }
        return res;
    }
}
