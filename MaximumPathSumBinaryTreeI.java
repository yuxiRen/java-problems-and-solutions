public class MaximumPathSumBinaryTreeI {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }
    private int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        if (root.left != null && root.right != null) {
            max = Math.max(max, root.key + left + right);
            return root.key + Math.max(left, right);
        }
        return root.left == null ? root.key + right : root.key + left;
    }
}
