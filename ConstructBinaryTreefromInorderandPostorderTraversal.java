public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            idxMap.put(inOrder[i], i);
        }
        return reconstruct(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, idxMap);
    }

    private TreeNode reconstruct(int[] inOrder, int inOrderLeft, int inOrderRight, int[] postOrder, int postOrderLeft, int postOrderRight, Map<Integer, Integer> idxMap) {
        if (inOrderLeft > inOrderRight) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postOrderRight]);
        int rootIdx = idxMap.get(postOrder[postOrderRight]);
        int leftSize = rootIdx - inOrderLeft;
        root.left = reconstruct(inOrder, inOrderLeft, rootIdx - 1, postOrder, postOrderLeft, postOrderLeft + leftSize - 1, idxMap);
        root.right = reconstruct(inOrder, rootIdx + 1, inOrderRight, postOrder, postOrderLeft + leftSize, postOrderRight - 1, idxMap);
        return root;
    }
}
