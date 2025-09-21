package LinkedList;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k==0) return null;

        int i = 1;
        while(i < k) {
            for(int j = 0; j + i < k; j = j + i*2) {
                lists[j] = mergeList(lists[j], lists[j + i]);
            }
            i *= 2;
        }

        return lists[0];
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        if(list1.val <= list2.val) {
            list1.next = mergeList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeList(list1, list2.next);
            return list2;
        }
    }
}
