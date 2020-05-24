public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(nums[idx]);
        dfs(nums, idx + 1, cur, res);
        cur.remove(cur.size() - 1);
        while (idx < nums.length - 1 && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        dfs(nums, idx + 1, cur, res);
    }

}
