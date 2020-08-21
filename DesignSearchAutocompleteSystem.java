public class DesignSearchAutocompleteSystem {
    TrieNode root = new TrieNode();
    TrieNode cur = root;
    StringBuilder sb = new StringBuilder();
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    private void insert(String s, int t) {
        TrieNode tmp = root;
        List<TrieNode> visited = new ArrayList<>();
        for (char c : s.toCharArray()) {
            int index = c == ' ' ? 26 : c - 'a';
            if (tmp.children[index] == null) {
                tmp.children[index] = new TrieNode();
            }
            tmp = tmp.children[index];
            visited.add(tmp);
        }
        tmp.word = s;
        tmp.time += t;
        //经过的每个prefix都有其最后产生的成果string
        for (TrieNode n : visited) {
            n.update(tmp);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            insert(sb.toString(), 1);
            sb = new StringBuilder();
            cur = root;
            return res;
        }
        sb.append(c);
        int index = c == ' ' ? 26 : c - 'a';
        if (cur != null) {
            cur = cur.children[index];
        }
        if (cur == null) {
            return res;
        }
        for (TrieNode hot : cur.hotWord) {
            res.add(hot.word);
        }
        return res;
    }

    class TrieNode {
        TrieNode[] children;
        String word;
        int time;
        List<TrieNode> hotWord;
        public TrieNode() {
            children = new TrieNode[27];
            hotWord = new ArrayList<>();
        }
        public void update(TrieNode s) {
            if (!hotWord.contains(s)) {
                hotWord.add(s);
            }
            Collections.sort(hotWord, (x, y) -> {
                if (x.time == y.time) {
                    return x.word.compareTo(y.word);
                }
                return y.time - x.time;
            });
            if (hotWord.size() > 3) {
                hotWord.remove(hotWord.size() - 1);
            }
        }
    }
}
