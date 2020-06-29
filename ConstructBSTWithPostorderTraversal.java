public class ConstructBSTWithPostorderTraversal {
    private int idx;
    public TreeNode reconstruct(int[] post) {
        idx = post.length - 1;
        return reconstruct(post, Integer.MIN_VALUE);
    }
    private TreeNode reconstruct(int[] post, int parentVal) {
        if (idx < 0 || post[idx] < parentVal) {
            return null;
        }
        TreeNode root = new TreeNode(post[idx--]);
        root.right = reconstruct(post, root.key);
        root.left = reconstruct(post, parentVal);
        return root;
    }
}
