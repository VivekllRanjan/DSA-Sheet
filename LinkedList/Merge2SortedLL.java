package LinkedList;

public class Merge2SortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode(-1);
        ListNode node = result;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val){
                node.next = list1;
                list1 = list1.next;
            }
            else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        node.next = (list1 != null) ? list1 : list2;

        return result.next;
    }
}
