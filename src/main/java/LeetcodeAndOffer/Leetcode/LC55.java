package LeetcodeAndOffer.Leetcode;

public class LC55 {
    public boolean canJump(int[] nums) {
        int index = 0;
        int maxJump = nums[0];

        while (index <= maxJump) {
            maxJump = Math.max(maxJump, index + nums[index]);
            if (maxJump >= nums.length - 1) return true;
            index++;

        }
        return false;
    }
}
