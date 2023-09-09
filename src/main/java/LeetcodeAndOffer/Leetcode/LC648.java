package LeetcodeAndOffer.Leetcode;

import java.util.List;

public class LC648 {
    class TrieNode {
        boolean val = false;

        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            int index = w - 'a';

            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }

            cur = cur.children[index];
        }
        cur.val = true;
    }

    private String search(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (cur.children[index] == null) {
                return word;
            }

            if (cur.children[index].val) {
                return word.substring(0, i + 1);
            }

            cur = cur.children[index];
        }
        return word;
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            insert(s);
        }

        StringBuilder stringBuilder = new StringBuilder();
        String[] split = sentence.split(" ");
        for (String s : split) {
            stringBuilder.append(search(s)).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
