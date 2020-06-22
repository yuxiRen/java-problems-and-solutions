public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }

        if (count < k) {
            return head;
        }
        cur = reverseKGroup(cur, k);
        for (int i = 0; i < k; i++) {
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }
}
