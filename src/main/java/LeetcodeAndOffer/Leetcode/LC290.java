package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;
import java.util.Objects;

public class LC290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) return false;

        HashMap<Character, String> hashMap1 = new HashMap<>();
        HashMap<String, Character> hashMap2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String string = strings[i];

            if (hashMap1.containsKey(c) || hashMap2.containsKey(string)) {
                String s1 = hashMap1.get(c);
                Character c1 = hashMap2.get(string);

                // 注意对象比较
                if (!Objects.equals(string, s1) || !c1.equals(c)) return false;

            } else {
                hashMap1.put(c, string);
                hashMap2.put(string, c);
            }
        }
        return true;
    }
}
