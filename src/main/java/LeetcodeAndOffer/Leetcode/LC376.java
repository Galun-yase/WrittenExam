package LeetcodeAndOffer.Leetcode;

public class LC376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int beginState = 0;
        int upState = 1;
        int downState = 2;

        int state = beginState;
        int length = 1;

        for (int i = 1; i < nums.length; i++) {

            if (state == beginState) {
                if (nums[i] > nums[i - 1]) {
                    state = upState;
                    length++;
                } else if (nums[i] < nums[i - 1]) {
                    state = downState;
                    length++;
                }

            } else if (state == upState) {

                if (nums[i] < nums[i - 1]) {
                    state = downState;
                    length++;
                }

            } else if (state == downState) {

                if (nums[i] > nums[i - 1]) {
                    state = upState;
                    length++;
                }

            } else {
                // do nothing
            }

        }
        return length;
    }
}
