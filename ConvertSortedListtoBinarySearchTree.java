public class ConvertSortedListtoBinarySearchTree {
    //method2.
    private ListNode cur;
    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }

    //method1
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int end = 0;
        while (head != null) {
            head = head.next;
            end++;
        }
        return sortedListToBST(0, end);
    }
    private TreeNode sortedListToBST(int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(start, mid);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
