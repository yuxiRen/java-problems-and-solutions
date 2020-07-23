public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (--k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }
}
