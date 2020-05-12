//Time: O(M+N)
public class MergeTwoSortedLinkedLists {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (one != null && two != null) {
          if (one.value < two.value) {
            cur.next = one;
            one = one.next;
          } else {
            cur.next = two;
            two = two.next;
          }
          cur = cur.next;
        }
    
        if (one != null) {
          cur.next = one;
        } else {
          cur.next = two;
        }
        return head.next;
      }

}