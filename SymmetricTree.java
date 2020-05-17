public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode one = queue.poll();
            TreeNode two = queue.poll();
            if (one.key != two.key) {
                return false;
            }
            if (one.left != null && two.right != null) {
                queue.offer(one.left);
                queue.offer(two.right);
            } else if (one.left != null || two.right != null) {
                return false;
            }

            if (one.right != null && two.left != null) {
                queue.offer(one.right);
                queue.offer(two.left);
            } else if (one.right != null || two.left != null) {
                return false;
            }
        }
        return true;
    }
}