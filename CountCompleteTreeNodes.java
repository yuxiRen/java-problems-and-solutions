public class CountCompleteTreeNodes {
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return getHeight(root.left) + 1;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = getHeight(root);
        int rightHeight = getHeight(root.right);
        // 左子树是 perfect binary tree
        if (rightHeight == height - 1) {
            // 左子树高度和右子树高度相等
            // 左子树加右子树加根节点
            //return (1 << rightHeight) - 1  + countNodes(root.right) + 1;
            return (1 << rightHeight) + countNodes(root.right);
            // 右子树是 perfect binary tree
        } else {
            // 左子树加右子树加根节点
            //return countNodes(root.left) + (1 << rightHeight) - 1 + 1;
            return countNodes(root.left) + (1 << rightHeight);
        }
    }
}
