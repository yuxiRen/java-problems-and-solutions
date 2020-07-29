public class FlattenBinaryTreetoLinkedList {
    //method1.
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        TreeNode cur = root;
        //走完左子树
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }

}

