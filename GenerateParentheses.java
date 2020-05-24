public class GenerateParentheses {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, n, sb, res);
        return res;
    }
    private void dfs(int left, int right, StringBuilder sb, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, sb.append("("), res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            dfs(left, right - 1, sb.append(")"), res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

