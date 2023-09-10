package LeetcodeAndOffer.Leetcode;

public class LC45 {
    public int jump(int[] nums) {

        int curPos = 0;
        int step = 0;

        while (curPos < nums.length - 1) {

            int right = curPos + nums[curPos];
            if (right >= nums.length - 1) return step + 1;

            int nextRight = right;
            int nextPos = curPos;

            for (int i = curPos + 1; i <= right; i++) {

                int max = i + nums[i];

                if (max > nextRight) {
                    nextRight = max;
                    nextPos = i;
                }
            }

            curPos = nextPos;
            step++;
        }
        return step;
    }
}
