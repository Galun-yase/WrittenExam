package LeetcodeAndOffer.Leetcode;

import sun.tools.jinfo.JInfo;

import java.util.*;
import java.util.stream.Collectors;

public class LC26 {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int slow = 0;

        for (int fast = slow; fast < nums.length; fast++) {
            if (set.contains(nums[fast])) continue;
            nums[slow] = nums[fast];
            slow++;
            set.add(nums[fast]);

        }
        return slow;

    }
}
