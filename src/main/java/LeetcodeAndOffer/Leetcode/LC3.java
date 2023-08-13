package LeetcodeAndOffer.Leetcode;

import java.util.HashSet;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashSet<Character> hashSet = new HashSet<>();

        int start = 0;
        for (int end = 0; end < s.length(); end++) {

            while (hashSet.contains(s.charAt(end))) {
                hashSet.remove(s.charAt(start));
                start++;
            }

            hashSet.add(s.charAt(end));
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
