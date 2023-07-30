package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class LC49 {
    public ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            int[] array = new int[26];
            for (int j = 0; j < str.length(); j++) {
                array[str.charAt(j) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (array[j] != 0) {
                    sb.append('a' + j);
                    sb.append(array[j]);
                }
            }
            ArrayList<String> list = hashMap.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            hashMap.put(sb.toString(), list);
        }

        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat", "ac", "bd", "aac", "bbd", "aacc", "bbdd", "acc", "bdd"};

        ArrayList<ArrayList<String>> arrayLists = new LC49().groupAnagrams(strs);
    }
}
