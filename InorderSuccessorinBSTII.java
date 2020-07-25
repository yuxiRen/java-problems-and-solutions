public class InorderSuccessorinBSTII {
    public Node inorderSuccessor(Node p) {
        if (p == null) {
            return null;
        }
        if (p.right != null) {
            return leftMost(p.right);
        } else if (p.parent != null && p.parent.left == p) {
            return p.parent;
        } else {
            while (p.parent != null && p.parent.right == p) {
                p = p.parent;
            }
            return p.parent;
        }
    }

    private Node leftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
