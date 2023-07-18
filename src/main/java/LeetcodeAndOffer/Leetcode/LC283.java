package LeetcodeAndOffer.Leetcode;

public class LC283 {


    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = slow; fast < nums.length; fast++) {
            if (nums[fast] == 0) continue;
            nums[slow] = nums[fast];
            slow++;
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public void moveZeroes_second(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {
        int[] ints = {1, 0, 1};
        new LC283().moveZeroes(ints);
    }
}
