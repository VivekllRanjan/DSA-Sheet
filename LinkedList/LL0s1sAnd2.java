package LinkedList;

public class LL0s1sAnd2 {
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    public Node segregate(Node head) {
        if (head == null || head.next == null)
            return head;

        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);

        Node hZero = zero;
        Node hOne = one;
        Node hTwo = two;

        Node curr = head;

        while(curr != null){
            if(curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            }
            else if(curr.data == 1) {
                one.next = curr;
                one = one.next;
            }
            else{
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        zero.next = (hOne.next != null)? hOne.next : hTwo.next;
        one.next = hTwo.next;
        two.next = null;

        head = hZero.next;

        return head;

    }

    public static void main(String[] args) {

    }
}
