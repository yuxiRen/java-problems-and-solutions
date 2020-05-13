public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
          return head;
        }
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode curSmall = small;
        ListNode curBig = big;
    
        while (head != null) {
          if (head.value < target) {
            curSmall.next = head;
            curSmall = curSmall.next;
          } else {
            curBig.next = head;
            curBig = curBig.next;
          }
          head = head.next;
        }
        curSmall.next = big.next;
        curBig.next = null;
        return small.next;
      }
}