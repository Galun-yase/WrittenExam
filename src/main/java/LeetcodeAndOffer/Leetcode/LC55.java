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

    public boolean canJump_2(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            maxIndex = Math.max(maxIndex, i + num);
            if (maxIndex == i && i != nums.length - 1) return false;
        }

        return maxIndex >= nums.length - 1;
    }
}
