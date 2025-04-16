package LinkedList;

public class SimpleOperations {
    Node head;
    int size;

    SimpleOperations(){
        this.size =0;
    }

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
            size ++;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList(){
        if(head == null) {System.out.println("LL empty"); return;}

        Node curr = head;
        while(curr != null){
            System.out.print(curr.data +" -> ");
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println("   Size: "+size);
    }

    public void delFirst(){
        if(head == null) return;
        size--;
        head = head.next;
    }

    public void delLast(){
        if(head == null) return;

        size--;
        if(head.next == null) {
            head = null;
            return;
        }

        Node last = head.next;
        Node secLast = head;
        while(last.next != null){
            last = last.next;
            secLast = secLast.next;
        }
        secLast.next = null;
    }

    public static void main(String[] args) {
        SimpleOperations list = new SimpleOperations();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.addFirst(0);
        list.printList();
        list.delFirst();
        list.delLast();
        list.delLast();
        System.out.println();
        list.printList();
    }
}
