public class FirstUniqueNumber {
    private Map<Integer, Node> map;
    private Node tail;
    private Node head;
    public FirstUnique(int[] nums) {
        map = new HashMap<Integer, Node>();
        head = tail = new Node(-1);
        for (int n : nums) {
            add(n);
        }
    }

    public int showFirstUnique() {
        return head.next == null ? -1 : head.next.key;
    }

    public void add(int value) {
        if (map.containsKey(value)) {
            Node node = map.get(value);
            if (node == null) {
                return;
            } else {
                remove(map.get(value));
                map.put(value, null);
            }
        } else {
            Node node = new Node(value);
            map.put(value, node);
            append(node);
        }

    }

    private void append(Node node) {
        if (head.next == null) {
            head.next = node;
            node.prev = head;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    private void remove(Node node) {

        if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
    }

    class Node {
        Integer key;
        private Node prev;
        private Node next;

        Node(Integer ch) {
            this.key = ch;
        }
    }

}
