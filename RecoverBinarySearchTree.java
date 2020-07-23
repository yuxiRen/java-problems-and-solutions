public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();
        TreeNode x = null, y = null, prev = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (prev != null && prev.val > root.val) {
                    x = root;
                    if (y == null) {
                        y = prev;
                    } else {
                        break;
                    }
                }
                prev = root;
                root = root.right;
            }
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
