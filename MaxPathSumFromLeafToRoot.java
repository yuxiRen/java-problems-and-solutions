public class MaxPathSumFromLeafToRoot {
    public int max = Integer.MIN_VALUE;
    public int maxPathSumLeafToRoot(TreeNode root) {
        maxSum(root, 0);
        return max;
    }
    private void maxSum(TreeNode root, int prevSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.key + prevSum);
            return;
        }
        maxSum(root.left, root.key + prevSum);
        maxSum(root.right, root.key + prevSum);
    }
}
