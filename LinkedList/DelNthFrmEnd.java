package LinkedList;

public class DelNthFrmEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast =head, slow = head;
        if(head == null) return head;

        //Move fast pointer n steps
        for(int i=1;i<=n;i++){
            fast = fast.next;
        }

        //If fast reached null, we're deleting the head as there are only n elements
        if(fast == null){
            return head.next;

        }

        //Move both until fast reaches the end
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        //Skip the nth node
        slow.next = slow.next.next;

        return head;
    }
}
