package LeetcodeAndOffer.Leetcode;

public class LC676 {

    class TrieNode {
        boolean val = false;

        TrieNode[] children = new TrieNode[26];
    }

    class MagicDictionary {

        TrieNode root;

        public MagicDictionary() {
            root = new TrieNode();
        }

        public void buildDict(String[] dictionary) {
            for (String d : dictionary) {
                TrieNode cur = root;

                for (int i = 0; i < d.length(); i++) {
                    int index = d.charAt(i) - 'a';
                    if (cur.children[index] == null) {
                        cur.children[index] = new TrieNode();
                    }
                    cur = cur.children[index];
                }
                cur.val = true;
            }
        }

        public boolean search(String searchWord) {
            for (int i = 0; i < searchWord.length(); i++) {
                if (dfs(searchWord, 0, i, root)) return true;
            }
            return false;
        }

        private boolean dfs(String searchWord, int index, int changeIndex, TrieNode node) {
            if (node == null) return false;
            if (index == searchWord.length()) return node.val;

            int i = searchWord.charAt(index) - 'a';
            if (index == changeIndex) {
                for (int j = 0; j < 26; j++) {
                    if (j == i) continue;
                    if (dfs(searchWord, index + 1, changeIndex, node.children[j])) return true;
                }
                return false;
            } else {
                return dfs(searchWord, index + 1, changeIndex, node.children[i]);
            }
        }
    }
}
