class LRU {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return head.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            node.value = value;
        } else {
            Node node = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            setHead(node);
            map.put(key, node);
        }
    }

    private void remove(Node node) {
        if (node == this.head) {
            this.head = this.head.next;
        } else if (node == this.tail) {
            this.tail = tail.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
    }

    private void setHead(Node node) {
        if (head == null) {
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
        }
        this.head = node;
    }

    static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;
        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
}
