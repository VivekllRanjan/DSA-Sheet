package LinkedList;

public class Add2Nums {

    public class ListNode {
        int val;
        OddEvenLL.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, OddEvenLL.ListNode next) { this.val = val; this.next = next; }
    }

    public OddEvenLL.ListNode addTwoNumbers(OddEvenLL.ListNode t1, OddEvenLL.ListNode t2) {
        OddEvenLL.ListNode dummy = new ListNode(-1);
        OddEvenLL.ListNode curr = dummy;
        int carry = 0;
        while(t1 != null || t2 != null){
            int sum = 0;
            if(t1 != null){
                sum += t1.val;
                t1 = t1.next;
            }
            if(t2 != null){
                sum += t2.val;
                t2 = t2.next;
            }

            sum += carry;
            carry = sum / 10;
            OddEvenLL.ListNode newNode = new ListNode(sum % 10);
            curr.next = newNode;
            curr = curr.next;
        }

        if (carry > 0){
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
