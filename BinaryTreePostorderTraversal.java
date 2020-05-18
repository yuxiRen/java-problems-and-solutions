public class BinaryTreePostorderTraversal {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
          return res;
        }
    
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
          TreeNode cur = stack.pop();
          res.add(cur.key);
          if (cur.left != null) {
            stack.push(cur.left);
          }
          if (cur.right != null) {
            stack.push(cur.right);
          }
        }
        Collections.reverse(res);
        return res;
      }
}