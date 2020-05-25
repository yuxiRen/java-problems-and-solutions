public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, new ArrayList<Integer>(), res, 0);
        return res;
    }
    private void dfs(int[] candidates, int balance, List<Integer> cur, List<List<Integer>> res, int idx) {
        if (balance == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        } else if (idx == candidates.length) {
            return;
        }
        int times = balance / candidates[idx];
        for (int i = 0; i <= times; i++) {
            add(cur, i, candidates[idx]);
            dfs(candidates, balance - i * candidates[idx], cur, res, idx + 1);
            remove(cur, i);
        }
    }
    private void add(List<Integer> cur, int times, int num ) {
        for (int i = 0; i < times; i++) {
            cur.add(num);
        }
    }
    private void remove(List<Integer> cur,int times) {
        for (int i = 0; i < times; i++) {
            cur.remove(cur.size() - 1);
        }
    }
}
