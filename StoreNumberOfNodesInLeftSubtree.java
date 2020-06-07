public class StoreNumberOfNodesInLeftSubtree {
    public int num(TreeNodeLeft root) {
        if (root == null) {
            return 0;
        }
        int left = num(root.left);
        int right = num(root.right);
        root.numNodesLeft = left;
        return left + right + 1;
    }
}
public class TreeNodeLeft {
    int key;
    TreeNodeLeft left;
    TreeNodeLeft right;
    int numNodesLeft;
    TreeNodeLeft(int key) {
        this.key = key;
    }
}