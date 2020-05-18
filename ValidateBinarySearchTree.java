public class ValidateBinarySearchTree {
    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }
      private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
          return true;
        }
        if (root.key <= min || root.key >= max) {
          return false;
        }
        return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
      }
}