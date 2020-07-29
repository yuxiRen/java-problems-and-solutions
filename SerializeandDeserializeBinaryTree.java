public class SerializeandDeserializeBinaryTree {
    //method1. BFS: levelorder
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("#").append(" ");
            } else {
                sb.append(cur.val).append(" ");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] tree = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(tree[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < tree.length) {
            TreeNode cur = queue.poll();
            if (!tree[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.valueOf(tree[i]));
                cur.left = left;
                queue.offer(left);
            }
            i++;
            if (i < tree.length && !tree[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.valueOf(tree[i]));
                cur.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }
}
