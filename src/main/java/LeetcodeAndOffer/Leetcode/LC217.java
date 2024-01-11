package LeetcodeAndOffer.Leetcode;

import java.util.HashSet;

public class LC217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }

    public boolean containsDuplicate_second(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    public boolean containsDuplicate_3(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) return true;
        }
        return false;
    }
}
