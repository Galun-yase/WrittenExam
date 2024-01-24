package LeetcodeAndOffer.Leetcode;

import java.util.*;

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
        new LC264().nthUglyNumber_4(10);
    }

    public int nthUglyNumber_3(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        HashSet<Long> hashSet = new HashSet<>();
        queue.offer(1L);
        hashSet.add(1L);

        int index = 0;
        while (index < n - 1) {
            Long integer = queue.poll();

            System.out.println(integer);

            Long i = integer * 2;
            Long j = integer * 3;
            Long k = integer * 5;

            if (!hashSet.contains(i)) {
                queue.offer(i);
                hashSet.add(i);
            }
            if (!hashSet.contains(j)) {
                queue.offer(j);
                hashSet.add(j);
            }
            if (!hashSet.contains(k)) {
                queue.offer(k);
                hashSet.add(k);
            }

            index++;
        }
        return queue.poll().intValue();
    }

    public int nthUglyNumber_4(int n) {
        long[] dp = new long[n];
        dp[0] = 1;

        int s_index = 0;
        int t_index = 0;
        int f_index = 0;

        for (int i = 1; i < n; i++) {
            long value2 = dp[s_index] * 2;
            long value3 = dp[t_index] * 3;
            long value5 = dp[f_index] * 5;

            long min = Math.min(Math.min(value2, value3), value5);
            if (min == value2) {
                s_index++;
            }
            if (min == value3) {
                t_index++;
            }
            if (min == value5) {
                f_index++;
            }
            dp[i] = min;
        }
        return (int) dp[n - 1];
    }
}
