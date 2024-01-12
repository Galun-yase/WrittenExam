package LeetcodeAndOffer.Leetcode;

public class LC242 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        for (int j : count) {
            if (j != 0) return false;
        }

        return true;

    }

    public boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map[c - 'a']--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) return false;
        }
        return true;
    }
}
