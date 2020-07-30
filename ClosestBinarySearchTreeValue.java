public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (root.val == target) {
                return root.val;
            }
            res = Math.abs(res - target) > Math.abs(root.val - target) ? root.val : res;
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
