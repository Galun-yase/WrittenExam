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

    public int lengthOfLongestSubstring_2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> hashSet = new HashSet<>();

        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            while (hashSet.contains(c)) {
                hashSet.remove(s.charAt(left));
                left++;
            }
            hashSet.add(c);
            res = Math.max(res, i - left + 1);

        }
        return res;
    }
}
