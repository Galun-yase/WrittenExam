package LeetcodeAndOffer.Leetcode;

public class LC169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int major = 0;

        // 记录擂主，同样的则加一，不同的同归于尽
        for (int num : nums) {
            if (count == 0) {
                major = num;
            }

            if ((major ^ num) == 0) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    public int majorityElement_2(int[] nums) {
        int count = 0;
        int major = 0;

        for (int num : nums) {
            if (count == 0) {
                major = num;
            }

            if ((major ^ num) == 0) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
