package LeetcodeAndOffer.Leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LC349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toCollection(HashSet::new));
        HashSet<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toCollection(HashSet::new));

        ArrayList<Integer> res = new ArrayList<>();
        for (int num1 : set1) {
            if (set2.contains(num1)) {
                res.add(num1);
            }
        }

        return res.stream().mapToInt(a -> a).toArray();
    }

    public int[] intersection_2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], 0);
        }

        for (int num : nums2) {
            if (hashMap.containsKey(num)) {
                set.add(num);
            }
        }

        int[] res = new int[set.size()];
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
