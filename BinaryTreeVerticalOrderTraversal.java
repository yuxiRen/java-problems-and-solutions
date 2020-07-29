public class BinaryTreeVerticalOrderTraversal {
    //BFS time: O(N), space: O(N)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> colIndex = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int minCol = 0;
        int maxCol = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();
            TreeNode node = cur.getKey();
            int col = cur.getValue();

            if (!colIndex.containsKey(col)) {
                colIndex.put(col, new ArrayList<Integer>());
            }
            colIndex.get(col).add(node.val);
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            if (node.left != null) {
                queue.offer(new Pair(node.left, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, col + 1));
            }
        }

        for (int i = minCol; i <= maxCol; i++) {
            res.add(colIndex.get(i));
        }
        return res;
    }
}
