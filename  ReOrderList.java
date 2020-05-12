public class  ReOrderList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
          return head;
        }
        ListNode mid = findMid(head);
        ListNode tmp = mid.next;
        mid.next = null;
        ListNode secondHead = reverse(tmp);
        return merge(head, secondHead);
     }
}