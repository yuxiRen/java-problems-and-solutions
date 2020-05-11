public class ReverseLinkedList {
    // M1. Iterate
    // 每次只做一个操作：head.next = prev
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // M2. Recursive
    // 1→ 2→ 3→ 4→ null
    // 最后一次recursion：newHead为4，head.next为2
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        // reverse the pointer from head to its next
        head.next.next = head;
        // remove the head’s next pointer
        head.next = null;
        return newHead;
    }

}