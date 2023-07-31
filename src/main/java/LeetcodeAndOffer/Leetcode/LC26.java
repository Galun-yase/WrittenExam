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

    //第二版
    public int removeDuplicates_second(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (fast==0||nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public int removeDuplicates_third(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int cur = 0;
        int index = 1;

        while (index != nums.length) {
            if (nums[cur] != nums[index]) {
                cur++;
                nums[cur] = nums[index];
            }
            index++;
        }
        return cur + 1;
    }

    public int removeDuplicates_forth(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (slow == 0 || nums[fast] != nums[slow - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
