package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List<List<String>> groupAnagrams_2(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            String key = sumStr(str);

            if (hashMap.containsKey(key)) {
                List<String> list = hashMap.get(key);
                list.add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(key, list);
            }
        }

        return new ArrayList<>(hashMap.values());
    }

    static String sumStr(String str) {
        int[] ints = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            ints[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            char c = (char) (i + 'a');
            sb.append(c).append(ints[i]);
        }
        return sb.toString();
    }
}
