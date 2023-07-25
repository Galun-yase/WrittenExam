package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;

public class LC205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> hashMap1 = new HashMap<>();
        HashMap<Character, Character> hashMap2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (hashMap1.containsKey(c1) && hashMap1.get(c1) != c2) {
                return false;
            }

            if (hashMap2.containsKey(c2) && hashMap2.get(c2) != c1) {
                return false;
            }

            if (!hashMap1.containsKey(c1)) {
                hashMap1.put(c1, c2);
            }

            if (!hashMap2.containsKey(c2)) {
                hashMap2.put(c2, c1);
            }

        }
        return true;
    }
}
