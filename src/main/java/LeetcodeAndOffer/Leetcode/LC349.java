package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
}
