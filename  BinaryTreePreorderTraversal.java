public class  BinaryTreePreorderTraversal {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
          return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
          TreeNode cur = stack.pop();
          if (cur.right != null) {
            stack.push(cur.right);
          }
          if (cur.left != null) {
            stack.push(cur.left);
          }
          result.add(cur.key);
        }
        return result;
      }
}