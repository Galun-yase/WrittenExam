package LeetcodeAndOffer.Leetcode;

public class LC211 {

    class TrieNode {
        boolean val = false;

        TrieNode[] children = new TrieNode[26];
    }


    class WordDictionary {

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {

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
            return dfs(word, 0, root);
        }

        private boolean dfs(String word, int index, TrieNode node) {
            if (node == null) return false;
            if (word.length() == index) return node.val;

            int i = word.charAt(index) - 'a';

            if (word.charAt(index) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (dfs(word, index + 1, node.children[j])) return true;
                }
                return false;
            } else {
                return dfs(word, index + 1, node.children[i]);
            }
        }
    }
}
