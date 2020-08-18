public class DesignAddandSearchWordsDataStructure {
    class WordDictionary {
        private TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(word, 0, root);
        }

        private boolean search(String word, int index, TrieNode cur) {
            if (index == word.length()) {
                return cur.isWord;
            }
            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (cur.children[i] != null && search(word, index + 1, cur.children[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                return cur.children[c - 'a'] != null && search(word, index + 1, cur.children[c - 'a']);
            }
        }

        class TrieNode {
            TrieNode[] children;
            boolean isWord;
            public TrieNode() {
                this.children = new TrieNode[26];
                this.isWord = false;
            }
        }
    }
}
