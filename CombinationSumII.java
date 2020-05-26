public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
    private void dfs(int[] candidates, int balance, int idx,List<Integer> cur, List<List<Integer>> res) {
        if (balance == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if (idx == candidates.length || balance < 0) {
            return;
        }
        //choose idxth number
        cur.add(candidates[idx]);
        dfs(candidates, balance - candidates[idx], idx + 1,cur, res);
        cur.remove(cur.size() - 1);
        //didn’t choose idxth number
        //如果没有选第一个1，那么第二个1也不能选
        while (idx < candidates.length - 1 && candidates[idx + 1] == candidates[idx]) {
            idx++;
        }
        dfs(candidates, balance, idx + 1,cur, res);
    }
}
