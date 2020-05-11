/*
prove: if there's a cycle, slow and fast must meet.
proof by contradiction：if there's a cycle and slow and fast never meet.
if fast at position i, slow at position i - 1
but the last time fast at position i - 2, slow at position i-2
they meet at the laast time.
*/

public class LinkedListCycle {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
            return true;
        }
    }
    return false;

}