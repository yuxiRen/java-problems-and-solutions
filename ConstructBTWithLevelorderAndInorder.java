public class ConstructBTWithLevelorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            idxMap.put(inOrder[i], i);
        }
        List<TreeNode> levelOrderList = new ArrayList<>();
        for (int i : levelOrder) {
            levelOrderList.add(new TreeNode(i));
        }
        return reconstruct(levelOrderList, idxMap);
    }
    private TreeNode reconstruct(List<TreeNode> levelOrderList, Map<Integer, Integer> idxMap) {
        if (levelOrderList.isEmpty()) {
            return null;
        }
        TreeNode root = levelOrderList.remove(0);
        int rootIdx = idxMap.get(root.key);
        List<TreeNode> leftList = new ArrayList<>();
        List<TreeNode> rightList = new ArrayList<>();
        for (TreeNode node : levelOrderList) {
            int idx = idxMap.get(node.key);
            if (idx < rootIdx) {
                leftList.add(node);
            } else {
                rightList.add(node);
            }
        }
        root.left = reconstruct(leftList, idxMap);
        root.right = reconstruct(rightList, idxMap);
        return root;
    }
}
