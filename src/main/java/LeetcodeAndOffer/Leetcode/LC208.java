package LeetcodeAndOffer.Leetcode;

public class LC208 {

    class TrieNode {
        //存储是否是最后一个节点
        boolean val = false;

        TrieNode[] children = new TrieNode[26];
    }

    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                int index = c - 'a';

                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }

                cur = cur.children[index];
            }
            cur.val = true;
        }

        public boolean search(String word) {
            TrieNode cur = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                int index = c - 'a';

                if (cur.children[index] == null) {
                    return false;
                }

                cur = cur.children[index];
            }
            return cur.val;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;

            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);

                int index = c - 'a';

                if (cur.children[index] == null) {
                    return false;
                }

                cur = cur.children[index];
            }
            return true;
        }
    }
}
