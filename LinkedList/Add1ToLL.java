package LinkedList;

public class Add1ToLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public  ListNode reverseLL(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
         return prev;
    }
    public ListNode addOne(ListNode head){
        head = reverseLL(head);
        ListNode temp = head;
        int carry = 1;

        while(temp != null){
            temp.val += carry;
            if(temp.val < 10){
                carry = 0; break;
            }
            else {
                temp.val = 0;
                carry = 1;
            }

            if(temp.next == null && carry ==1){
                temp.next = new ListNode(0); // carry will get added in next iteration
            }

            temp = temp.next;
        }

        head = reverseLL(head);
        return head;

    }

    public int addOneRecursiveHelper(ListNode node){
        if(node == null) return 1;

        int carry = addOneRecursiveHelper(node.next);
        int sum = node.val + carry;
        node.val = sum % 10;
        return sum / 10;
    }

    public ListNode addOneRecursive(ListNode head){
        int carry = addOneRecursiveHelper(head);

        if (carry != 0) {
            // Add a new node at the front if carry is left
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Add1ToLL solution = new Add1ToLL();
        Add1ToLL.ListNode head = solution.new ListNode(9, solution.new ListNode(9, solution.new ListNode(9)));

        ListNode result = solution.addOne(head);
        printList(result); // Output: 1 0 0 0
    }
}
