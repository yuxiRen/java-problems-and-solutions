public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(n, res, cur);
        return res;
    }
    private void dfs(int n,  List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == n) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(i, cur)) {
                cur.add(i);
                dfs(n, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean isValid(int col, List<Integer> cur) {
        int prevRow = cur.size();
        for (int i = 0; i < prevRow; i++) {
            int prevCol =cur.get(i);
            if (prevCol == col || Math.abs(prevCol - col) == prevRow - i) {
                return false;
            }
        }
        return true;
    }
}
