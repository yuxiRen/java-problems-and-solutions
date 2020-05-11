public class LinkedListCycle {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    while (head != null && head.next != null) {
        slow = slow.next;
        head = head.next.next;
        if (slow == head) {
            return true;
        }
    }
    return false;

}