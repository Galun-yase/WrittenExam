package LeetcodeAndOffer.Leetcode;

public class LC80 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (slow < 2 || nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public int removeDuplicates_2(int[] nums) {

        int index = -1;

        for (int i = 0; i < nums.length; ) {
            int j = i;

            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }

            if (j - i >= 2) {
                index++;
                nums[index] = nums[i];
                index++;
                nums[index] = nums[i];
            } else {
                index++;
                nums[index] = nums[i];
            }
            i = j;
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 3};
        new LC80().removeDuplicates_2(ints);

    }
}
