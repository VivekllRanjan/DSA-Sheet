package LinkedList;

public class ReverseLinkedList extends SimpleOperations{

    public void revListIterate(){
        if(head == null || head.next == null) return;

        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //For next iteration
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public Node revListRecursive(Node head){
        if(head == null || head.next == null) return head;
        Node newHead = revListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.addFirst(0);
        list.printList();
        //list.delFirst();
        //list.delLast();
        //list.delLast();
        list.revListIterate();
        System.out.println();
        list.printList();
        list.head = list.revListRecursive(list.head);
        System.out.println();
        list.printList();
    }

}
