public class ClosestBinarySearchTreeValueII {
    // time : O(n) space : O(n)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root);
        while (res.size() > k) {
            if (Math.abs(target - res.peekFirst()) < Math.abs(target - res.peekLast())) {
                res.pollLast();
            } else {
                res.pollFirst();
            }
        }
        return res;
    }

    private void helper(LinkedList<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    //method2
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> predecessors = new ArrayDeque<>();
        Deque<TreeNode> successors = new ArrayDeque<>();
        inorder(root, target, predecessors, true);
        inorder(root, target, successors, false);
        while (res.size() < k) {
            if (predecessors.isEmpty()) {
                res.add(successors.pop().val);
            } else if (successors.isEmpty()) {
                res.add(predecessors.pop().val);
            } else if (Math.abs(predecessors.peek().val - target) < Math.abs(successors.peek().val - target)) {
                res.add(predecessors.pop().val);
            } else {
                res.add(successors.pop().val);
            }
        }
        return res;
    }

    private void inorder(TreeNode root, double target, Deque<TreeNode> stack, boolean isPredecessors) {
        if (root == null) {
            return;
        }
        inorder(isPredecessors ? root.left : root.right, target, stack, isPredecessors);
        if ((isPredecessors && root.val <= target) || (!isPredecessors && root.val > target)) {
            stack.push(root);
            inorder(isPredecessors ? root.right : root.left, target, stack, isPredecessors);
        }
    }
}
