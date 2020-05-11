public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode fast = head;
    while (fast.next != null&&fast.next.next != null) {
      head = head.next;
      fast = fast.next.next;
    }
    return head;
}