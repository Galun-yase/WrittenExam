package LeetcodeAndOffer.Leetcode;

import java.util.List;

public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();

        int[] dp = new int[size + 1];

        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public int minimumTotal_2(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);

            for (int j = 0; j < list.size(); j++) {
                Integer num = list.get(j);

                if (j == 0) {
                    Integer cur = triangle.get(i - 1).get(j);
                    list.set(j, num + cur);
                } else if (j == list.size() - 1) {
                    Integer pre = triangle.get(i - 1).get(j - 1);
                    list.set(j, num + pre);
                } else {
                    Integer cur = triangle.get(i - 1).get(j);
                    Integer pre = triangle.get(i - 1).get(j - 1);

                    list.set(j, num + Math.min(cur, pre));
                }
            }
        }

        int res = Integer.MAX_VALUE;
        List<Integer> last = triangle.get(triangle.size() - 1);
        for (Integer integer : last) {
            res = Math.min(res, integer);
        }
        return res;
    }
}
