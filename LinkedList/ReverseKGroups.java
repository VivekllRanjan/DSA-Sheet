package LinkedList;

public class ReverseKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int group = 0;
        while(curr != null && group < k) {
            curr= curr.next;
            group++;
        }

        if(group == k) {
            curr = reverseKGroup(curr, k);
            while (group-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }

        return head;
    }
}
