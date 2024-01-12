package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;

public class LC387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }

    public int firstUniqChar_3(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (hashMap.get(c) == 1) return i;
        }
        return -1;
    }
}
