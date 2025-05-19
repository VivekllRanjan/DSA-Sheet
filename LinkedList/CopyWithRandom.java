package LinkedList;

import java.util.HashMap;

public class CopyWithRandom {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            Node clone = map.get(temp);
            clone.next = map.get(temp.next);
            clone.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }

    public Node copyRandomListOptimal(Node head) {
        if(head == null) return null;

        //Interleave the copied nodes
        Node curr = head;
        while(curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        //Set the random pointers
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //Break the chains to the interleaved nodes
        curr = head;
        Node newHead = new Node(0);
        Node copyCurr = newHead;
        while(curr != null) {
            Node copy = curr.next;
            curr.next = copy.next; //Restore original
            copyCurr.next = copy; //Breakout the copied node

            copyCurr = copy;
            curr = curr.next;
        }

        return newHead.next;
    }
}
