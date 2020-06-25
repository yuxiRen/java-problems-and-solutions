public class LCAofKNodesinKnaryTree {
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        Set<KnaryTreeNode> set = new HashSet<>(nodes);
        if (root == null || set.contains(root)) {
            return root;
        }
        int count = 0;
        KnaryTreeNode cur = null;
        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode childLCA = lowestCommonAncestor(child, nodes);
            if (childLCA != null) {
                count++;
                cur = childLCA;
            }
        }
        if (count >= 2) {
            return root;
        }
        return cur;
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