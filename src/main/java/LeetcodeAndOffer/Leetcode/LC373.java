package LeetcodeAndOffer.Leetcode;

import java.util.*;

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

    public List<List<Integer>> kSmallestPairs_2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<List<Integer>> heap = new PriorityQueue<>((a, b) -> {
            int i = nums1[a.get(0)] + nums2[a.get(1)];
            int j = nums1[b.get(0)] + nums2[b.get(1)];

            return i - j;
        });
        HashSet<String> hashSet = new HashSet<>();


        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        heap.add(list);
        hashSet.add("0_0");

        for (int i = 0; i < k; i++) {
            List<Integer> poll = heap.poll();


            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(nums1[poll.get(0)]);
            arrayList.add(nums2[poll.get(1)]);
            System.out.println(arrayList.get(0) + " : " + arrayList.get(1));
            res.add(arrayList);

            Integer index1 = poll.get(0);
            Integer index2 = poll.get(1);


            if (index1 + 1 < nums1.length && hashSet.add(index1 + 1 + "_" + index2)) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(index1 + 1);
                l.add(index2);

                heap.add(l);
            }
            if (index2 + 1 < nums2.length && hashSet.add(index1 + "_" + (index2 + 1))) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(index1);
                l.add(index2 + 1);

                heap.add(l);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3, 5, 7, 9};
        int k = 20;

        List<List<Integer>> lists = new LC373().kSmallestPairs_2(nums1, nums2, k);


    }
}
