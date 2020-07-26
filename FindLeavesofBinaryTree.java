public class FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }

    private int height(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return -1;
        }
        int curHeight = Math.max(height(root.left, res), height(root.right, res)) + 1;
        if (res.size() < curHeight + 1) {
            res.add(new ArrayList<Integer>());
        }
        res.get(curHeight).add(root.val);
        return curHeight;
    }
}
