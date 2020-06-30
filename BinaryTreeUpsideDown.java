public class BinaryTreeUpsideDown {
    //method1. recursion
    public TreeNode reverse(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = reverse(root.left);
        root.left.left = root;
        root.left.right = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }
    //method2. iteration
    public TreeNode reverse(TreeNode root) {
        TreeNode prevRoot = null;
        TreeNode prevRight = null;
        while (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = prevRoot;
            root.right = prevRight;
            prevRoot = root;
            root = left;
            prevRight = right;
        }
        return prevRoot;
    }
}
