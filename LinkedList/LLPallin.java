//https://leetcode.com/problems/palindrome-linked-list/

package LinkedList;

public class LLPallin {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverse(ListNode head){
        ListNode prevNode = head;
        ListNode currNode = head.next;

        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;

        }
        return prevNode;
    }





    public ListNode firstMiddle(ListNode head){
        ListNode hare = head;
        ListNode turtle = head;

        while(hare.next !=null && hare.next.next != null ){
            turtle = turtle.next;
            hare = hare.next.next;
        }
        return turtle; //middle of LL
    }




    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;


        ListNode middle = firstMiddle(head); // returns first half end
        ListNode secondHalfStart = reverse(middle.next);

        ListNode firstHalfStart = head;

        while(secondHalfStart != null){
            if(firstHalfStart.val != secondHalfStart.val){
                return false;
            }

            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }

        return true;


    }

    public static void main(String[] args) {

    }
}
