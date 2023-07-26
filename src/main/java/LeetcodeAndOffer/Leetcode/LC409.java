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
}
