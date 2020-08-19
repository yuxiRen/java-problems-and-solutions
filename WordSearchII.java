public class WordSearchII {
    private TrieNode root = new TrieNode();
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        buildTree(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void buildTree(String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
    }

    private void dfs(char[][] board, int row, int col, TrieNode cur, List<String> res) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        char c = board[row][col];
        if (c == '*' || cur.children[c - 'a'] == null) {
            return;
        }
        cur = cur.children[c - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        board[row][col] = '*';
        for (int i = 0; i < dirs.length; i++) {
            dfs(board, row + dirs[i][0], col + dirs[i][1], cur, res);
        }
        board[row][col] = c;
    }

    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            this.word = null;
            this.children = new TrieNode[26];
        }
    }
}
