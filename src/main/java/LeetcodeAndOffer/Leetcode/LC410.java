package LeetcodeAndOffer.Leetcode;

public class LC410 {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = subArray(nums, mid);

            if (cnt > k) {
                left = mid + 1;
            } else if (cnt < k) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int subArray(int[] nums, int sum) {
        int cnt = 1;
        int tmpSum = 0;
        for (int num : nums) {
            if (tmpSum + num > sum) {
                cnt++;
                tmpSum = 0;
            }
            tmpSum += num;
        }
        return cnt;
    }
}
