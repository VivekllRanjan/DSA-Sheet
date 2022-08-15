//https://leetcode.com/problems/remove-nth-node-from-end-of-list

package LinkedList;

public class RemoveNthFromEnd {

     //Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null){
            return null;
        }


        int size =0;

        ListNode curr = head;
        while(curr != null){

            curr = curr.next;
            size++;
        }

        if(n == size)
            return head.next;


        curr = head;
        int i =1;
        while(i<size-n){
            curr = curr.next;
            i++;
        }

        curr.next = curr.next.next;

        return head;

    }

    public static void main(String[] args) {


    }




}
