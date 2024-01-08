package LeetcodeAndOffer.Leetcode;

public class LC27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int slow = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    public int removeElement_2(int[] nums, int val) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }
}
