public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIdx.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIdx);
    }

    private TreeNode buildTree(int[] preorder, int preorderLeft, int preOrderRight, int[] inorder, int inorderLeft, int inorderRight, Map<Integer, Integer> inorderIdx) {
        if (inorderLeft > inorderRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        int idx = inorderIdx.get(preorder[preorderLeft]);
        int leftSize = idx - inorderLeft;
        root.left = buildTree(preorder, preorderLeft + 1, preorderLeft + leftSize, inorder, inorderLeft, idx - 1, inorderIdx);
        root.right = buildTree(preorder, preorderLeft + leftSize + 1, preOrderRight, inorder, idx + 1, inorderRight, inorderIdx);
        return root;
    }
}
