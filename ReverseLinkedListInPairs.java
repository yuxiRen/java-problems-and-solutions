public class ReverseLinkedListInPairs {
    //method1. recursion
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseInPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = next;
        return newHead;
    }
    //method2. iterative
    public ListNode reverseInPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = next.next;
            next.next = cur.next;
            cur.next = next;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
