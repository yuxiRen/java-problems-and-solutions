public class BalancedBinaryTree {
    //use -1 to denote the tree is not balanced.
    //>=0 value means the tree is balanced and it is the height of the tree
    //Time: O(N)
    //Space: O(logN)
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
          return true;
        }
        return height(root) != -1;
      }
    
      private int height(TreeNode root) {
        if (root == null) {
          return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1 
            || leftHeight == -1 || rightHeight == -1) {
          return -1;
        } else {
          return Math.max(leftHeight, rightHeight) + 1;
        }
      }
}