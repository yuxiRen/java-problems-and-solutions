public class LowestCommonAncestor {
//    case1. there’s no node in the subtree → return null
//    case2. there’s only one node in the subtree → return the node
//    case3. there’re both two nodes in the subtree → return the root
    //time: O(N)

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

    /*If there is parent pointer for the nodes in the binary tree
     * The time complexity is O(logN)*/
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        int oneLength = length(one);
        int twoLength = length(two);
        return lowestCommonAncestor(one, oneLength, two, twoLength);
    }

    private TreeNodeP lowestCommonAncestor(TreeNodeP one, int oneLength, TreeNodeP two, int twoLength) {
        int diff = oneLength - twoLength;
        if (diff > 0) {
            while (diff > 0) {
                one = one.parent;
                diff--;
            }
        } else if (diff < 0) {
            while (diff < 0) {
                two = two.parent;
                diff++;
            }
        }
        while (one != two) {
            one = one.parent;
            two = two.parent;
        }
        return one;
    }

    private int length(TreeNodeP node) {
        int length = 0;
        while (node != null) {
            node = node.parent;
            length++;
        }
        return length;
    }
}
