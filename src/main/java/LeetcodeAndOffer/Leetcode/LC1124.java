package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1124 {
    /**
     * 有点复杂
     *
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {
        // preSum:index
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int preSum = 0;
        int ans = 0;

        for (int i = 0; i < hours.length; i++) {
            preSum += hours[i] > 8 ? 1 : -1;

            if (preSum > 0) {
                ans = i + 1;
            } else {
                hashMap.putIfAbsent(preSum, i);

                if (hashMap.containsKey(preSum - 1)) {
                    Integer j = hashMap.get(preSum - 1);
                    int d = i - j;

                    ans = Math.max(ans, d);
                }
            }
        }
        return ans;
    }

    public int longestWPI_2(int[] hours) {

        int[] prefixSum = new int[hours.length + 1];

        for (int i = 0; i < hours.length; i++) {
            int hour = hours[i];
            if (hour > 8) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i] - 1;
            }
        }


        int res = 0;

        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < i; j++) {

                if (prefixSum[i] - prefixSum[j] > 0) {
                    res = Math.max(res, i - j);
                }
            }
        }
        return res;
    }
}
