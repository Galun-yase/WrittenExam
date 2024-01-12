package LeetcodeAndOffer.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        boolean flag = false;
        int res = 0;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            res += entry.getValue() / 2 * 2;

            if (entry.getValue() % 2 == 1) {
                flag = true;
            }
        }

        return flag ? res + 1 : res;
    }

    public int longestPalindrome_2(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        boolean odd = false;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 == 0) {
                res += value;
            } else {
                odd = true;
                res += value / 2 * 2;
            }
        }

        return odd ? res + 1 : res;
    }

}
