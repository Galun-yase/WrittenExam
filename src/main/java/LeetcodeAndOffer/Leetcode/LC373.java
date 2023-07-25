package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // [nums1_index,nums2_index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int i1 = nums1[a[0]] + nums2[a[1]];
            int i2 = nums1[b[0]] + nums2[b[1]];
            return i1 - i2;
        });

        // 两个默认递增的序列。最小的肯定在最前面，
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{i, 0});
        }

        List<List<Integer>> res = new ArrayList<>();

        while (k-- > 0 && !pq.isEmpty()) {
            int[] index = pq.poll();

            int index1 = index[0];
            int index2 = index[1];

            res.add(Arrays.asList(nums1[index1], nums2[index2]));

            // 弹出最小的，再把另一个的索引+1，与初始化时对应
            index2++;
            if (index2 < nums2.length) {
                pq.offer(new int[]{index1, index2});
            }
        }
        return res;
    }
}
