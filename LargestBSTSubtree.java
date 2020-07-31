public class LargestBSTSubtree {
    //method1. O(N^2)
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return count(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    private boolean isValid(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return count(root.left) + count(root.right) + 1;
    }
    //method2. O(N)
    public int largestBSTSubtree(TreeNode root) {
        return helper(root)[2];
    }
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if (root.val > left[1] && root.val < right[0]) {
            return new int[]{Math.min(root.val, left[0]), Math.max(root.val, right[1]), left[2] + right[2] + 1};
        } else {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }
}
