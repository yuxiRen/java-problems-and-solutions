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
}
