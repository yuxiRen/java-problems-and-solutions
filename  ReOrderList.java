/*
step1. find the middle node
step2. delink two half lists
step3. reverse the second list
step4. merge two lists together
*/
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