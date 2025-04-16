package LinkedList;

public class DLLOperations {
    Node head;
    Node tail;
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void printForward(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    public void printBackward(){
        Node curr = tail;
        while(curr != null){
            System.out.print(curr.data+ " <-> ");
            curr = curr.prev;
        }
        System.out.print("null");
    }

    public void convertArray2DLL(int[] arr){
        for(int i:arr) addLast(i);
    }

    public void deleteHead(){
        if(head == null ) return;
        if(head.next == null) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void deleteTail(){
        if(head == null ) return;
        if(head.next == null) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void delete(int n){
        if(head == null) return;

        Node curr = head;
        int index = 0;

        while (curr != null && index < n) {
            curr = curr.next;
            index++;
        }
        if (curr == null) return;
        // If deleting the only node
        if (head == tail && curr == head) {
            head = tail = null;
            return;
        }

        // If deleting the head
        if (curr == head) {
            head = head.next;
            head.prev = null;
            return;
        }

        // If deleting the tail
        if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    public void addNodeBeforeHead(Node node){
        if (head == null) {
            head = tail = node;
            node.prev = node.next = null;
            return;
        }
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }

    public void reverse(){
        Node curr = head;
        Node temp = null;

        while(curr!=null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr= curr.prev; //next element
        }
        if(temp != null){
            head = temp.prev;
        }
    }

    public void recursiveReverse(){
        head = reverseRecursiveHelper(head);
    }

    private Node reverseRecursiveHelper(Node curr) {
        if(curr == null) return null;

        Node temp = curr.next;
        curr.next = curr.prev;
        curr.prev = temp;

        if(curr.prev == null){
            tail = head;
            return curr;
        }
        return reverseRecursiveHelper(curr.prev);
    }


    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        DLLOperations list = new DLLOperations();
        list.convertArray2DLL(input);
        list.printForward();   // 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
        System.out.println();
        list.printBackward();  // 5 <-> 4 <-> 3 <-> 2 <-> 1 <-> null

    }
}
