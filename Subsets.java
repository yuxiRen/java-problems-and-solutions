//Time: O(2^N)
public class Subsets {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null || set.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(set, sb, 0, res);
        return res;
    }

    private void dfs(String s, StringBuilder sb, int idx, List<String> res) {
        if (idx == s.length()) {
            res.add(sb.toString());
            return;
        }
        dfs(s, sb, idx + 1, res);
        dfs(s, sb.append(s.charAt(idx)), idx + 1, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}
