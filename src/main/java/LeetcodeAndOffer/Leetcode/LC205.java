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

    public boolean isIsomorphic_2(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> hashMap1 = new HashMap<>();
        HashMap<Character, Character> hashMap2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if (hashMap1.containsKey(s1) && hashMap1.get(s1) != t1) return false;
            if (hashMap2.containsKey(t1) && hashMap2.get(t1) != s1) return false;
            hashMap1.put(s1, t1);
            hashMap2.put(t1, s1);

        }
        return true;
    }
}
