public class ClosestBinarySearchTreeValueII {
    // time : O(n) space : O(n)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root);
        while (res.size() > k) {
            if (Math.abs(target - res.peekFirst()) < Math.abs(target - res.peekLast())) {
                res.pollLast();
            } else {
                res.pollFirst();
            }
        }
        return res;
    }

    private void helper(LinkedList<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }
}
