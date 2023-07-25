package LeetcodeAndOffer.Leetcode;

import java.util.HashSet;
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
}
