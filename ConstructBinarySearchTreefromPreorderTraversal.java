public class ConstructBinarySearchTreefromPreorderTraversal {
    private int idx;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int parentVal) {
        if (idx >= preorder.length || preorder[idx] >= parentVal) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, parentVal);
        return root;
    }
}
