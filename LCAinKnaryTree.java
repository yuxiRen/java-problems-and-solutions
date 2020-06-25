public class LCAinKnaryTree {
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        if (root == null || root == a || root == b) {
            return root;
        }
        int count = 0;
        KnaryTreeNode found = null;
        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode LCA = lowestCommonAncestor(child, a, b);
            if (LCA != null) {
                count++;
                found = LCA;
            }
        }
        if (count == 2) {
            return root;
        }
        return found;
    }
}

public class KnaryTreeNode {
    int key;
    List<KnaryTreeNode> children;

    public KnaryTreeNode(int key) {
        this.key = key;
        this.children = new ArrayList<>();
    }
}
