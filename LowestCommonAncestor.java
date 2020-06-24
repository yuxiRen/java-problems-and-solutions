public class LowestCommonAncestor {
//    case1. there’s no node in the subtree → return null
//    case2. there’s only one node in the subtree → return the node
//    case3. there’re both two nodes in the subtree → return the root

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null || root == one || root == two) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
