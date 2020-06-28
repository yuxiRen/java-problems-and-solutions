public class ConvertBSTtoSortedDLL {
    private Node head = null;
    private Node tail = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        builder(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    private void builder(Node root) {
        if (root == null) {
            return;
        }
        builder(root.left);
        if (tail == null) {
            tail = root;
            head = root;
        } else {
            tail.right = root;
            root.left = tail;
            tail = root;
        }
        builder(root.right);
    }
}

