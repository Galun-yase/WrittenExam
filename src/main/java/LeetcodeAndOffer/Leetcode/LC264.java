package LeetcodeAndOffer.Leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class LC264 {
    public int nthUglyNumber(int n) {
        int[] factories = {2, 3, 5};
        long ugly = 1L;

        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 1; i < n; i++) {

            for (int factory : factories) {
                Long i1 = ugly * factory;

                if (set.add(i1)) {
                    pq.offer(i1);
                }
            }
            ugly = pq.poll();
        }
        // 存疑问，为什么会超出int还要强转
        return (int) ugly;
    }

    public int nthUglyNumber_second(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int s_index = 0;
        int t_index = 0;
        int f_index = 0;

        for (int i = 1; i < n; i++) {
            int s = dp[s_index] * 2;
            int t = dp[t_index] * 3;
            int f = dp[f_index] * 5;

            int min = Math.min(Math.min(s, t), f);
            // 分别判断，可以去重
            if (min == s) {
                s_index++;
            }
            if (min == t) {
                t_index++;
            }
            if (min == f) {
                f_index++;
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        new LC264().nthUglyNumber_second(10);
    }
}
